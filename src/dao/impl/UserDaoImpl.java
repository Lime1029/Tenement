package dao.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.UserDao;
import model.*;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional//事务注解
@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public boolean save(User user) {
        Session session= sessionFactory.getCurrentSession();
        try{
            //user.setRole("user"); // 这里设默认值，不然插入的就是null
            session.save(user);
        }catch(HibernateException e){
            return false;
        }
        finally {
            //session.close();//关闭连接
        }
        return true;
    }
    @Override
    public boolean savehouse(LandlordApplyRelease landlordApplyRelease) {
        Session session= sessionFactory.getCurrentSession();
        try{

            session.save(landlordApplyRelease);
        }catch(HibernateException e){
            return false;
        }
        finally {
            //session.close();//关闭连接
        }
        return true;
    }
    @Override
    public boolean confirmHouse(House house,String phone)
    {
        Session session= sessionFactory.getCurrentSession();
        try{

            int userid = getHouse_userid(phone);
            house.setLandlordId(userid);
            session.save(house);




        }catch(HibernateException e){
            return false;
        }
        finally {
            //session.close();//关闭连接
        }
        return true;

    }
    @Override
    public boolean messageSubmit(DiscussionSection discussionSection)
    {
        Session session= sessionFactory.getCurrentSession();
        try{

            session.save(discussionSection);
        }catch(HibernateException e){
            return false;
        }
        finally {
            //session.close();//关闭连接
        }
        return true;
    }


    @Override
    public User getUserByTel(String telphone) {
        /*Session session = sessionFactory.getCurrentSession();
        User user=null;
        user=(User)session.get(User.class,userId);//这里userId这个位置期盼的是int值
        return user;*/
        List<User> users=findByProperty("telephone",telphone, "user");
        if(users!=null&&users.size()==1) {

            return users.get(0);
        }
        return null;
    }
    @Override
    public Agent getAgentByTel(String telphone) {
        List<Agent> agents = findByProperty("telephone", telphone, "agent");
        if(agents!=null&&agents.size()==1) {

            return agents.get(0);
        }
        return null;
    }
    @Override
    public Administrator getAdminByTel(String telphone) {
        List<Administrator> administrators = findByProperty("telephone", telphone, "admin");
        if(administrators!=null&&administrators.size()==1){
            return administrators.get(0);
        }

        return null;
    }
    @Override
    public User findByLoginName(String username) {
        List<User> users=findByProperty("loginName",username, "user");
        if(users!=null&&users.size()==1)
            return users.get(0);
        return null;
    }
    public List findByProperty(String PropertyName,Object value, String role){
        Session session =sessionFactory.getCurrentSession();

        List<User> users = null;
        List<Agent> agents = null;
        List<Administrator> administrators = null;
        Criteria cr = null;
        if (role.equals("user")) {
            cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq(PropertyName,value));
            users=cr.list();
            return users;
        }
        else if (role.equals("agent")) {
            cr = session.createCriteria(Agent.class);
            cr.add(Restrictions.eq(PropertyName,value));
            agents=cr.list();
            return agents;
        }
        else {
            cr = session.createCriteria(Administrator.class);
            cr.add(Restrictions.eq(PropertyName,value));
            administrators=cr.list();
            return administrators;
        }


    }
    @Override
    public boolean updateUser(User user) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean updateUser(User user, String newpassword) {
        // TODO Auto-generated method stub
        return false;
    }
    public List getNotice()
    {
        Session session =sessionFactory.getCurrentSession();
        String sql = "select message,release_time,username from discussion_section,user where discussion_section.author_id=user.user_id order by release_time DESC limit 100 ";
        SQLQuery caller  = session.createSQLQuery(sql);
        return  caller.list();

    }

    @Override
    public List<Plot> getPlot() {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        Agent agent= (Agent) session.get("agent");
        int agentId = agent.getAgentId();
        String sql="select * FROM tenement.plot where agent_id='"+agentId+"';";
        Session session1 =sessionFactory.getCurrentSession();
        SQLQuery<Plot> query=session1.createSQLQuery(sql).addEntity(Plot.class);
        return  query.list();



    }

    @Override
    public List<Plot> plotGet() {
        String sql="select * FROM tenement.plot ;";
        Session session1 =sessionFactory.getCurrentSession();
        SQLQuery<Plot> query=session1.createSQLQuery(sql).addEntity(Plot.class);
        return  query.list();

    }

    public int getHouse_plotid(String phone)
    {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        Agent agent= (Agent) session.get("agent");
        int id;
        id = agent.getAgentId();
        return id;



    }
   public int getHouse_userid(String phone)
   {
       Session session =sessionFactory.getCurrentSession();
       String sql="select * FROM tenement.user where telephone='"+phone+"';";
       SQLQuery query=session.createSQLQuery(sql).addEntity(User.class);
       User user = (User)query.uniqueResult();
       int userId=user.getUserId();
       return userId;

   }



    public List getAllNotice() throws SQLException {
        List list = new ArrayList();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        String sql = "select message,release_time,username from discussion_section,user where discussion_section.author_id=user.user_id order by release_time DESC limit 100 ";
        try{
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Map messageBoards = new HashMap();
                messageBoards.put("messageContent", rs.getString("message"));
                messageBoards.put("messageTime", rs.getString("release_time"));
                messageBoards.put("userName", rs.getString("username"));
                list.add(messageBoards);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
