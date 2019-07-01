package dao.impl;

import dao.UserDao;
import model.User;
import model.Agent;
import model.Administrator;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import java.util.List;

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
            user.setRole("user"); // 这里设默认值，不然插入的就是null
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

}
