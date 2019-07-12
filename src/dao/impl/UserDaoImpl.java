package dao.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.UserDao;
import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.hibernate.SQLQuery;
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

            session.save(user);
        }catch(HibernateException e){
            return false;
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
    public List<HouseInfo> searchMyHouse(int userId) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "select new model.HouseInfo(d.districtName, p.plotName, h.address, a.name, h.rent, h.state," +
                " h.houseType, h.floor, h.area, h.releaseTime, h.houseId, a.telephone) from House as h, Plot as p, District as d, " +
                "Agent as a where h.plotId = p.plotId and d.districtId = p.districtId and p.agentId = a.agentId " +
                "and h.landlordId = " + userId;
        Query<HouseInfo> query = session.createQuery(hql);

        List<HouseInfo> houseInfoList = query.list();

        return houseInfoList;
    }
    @Override
    public List<HouseInfo> searchMyRentalHouse(int userId) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "select new model.HouseInfo(d.districtName, p.plotName, h.address, a.name, h.rent, h.state," +
                "h.houseType, h.floor, h.area, h.releaseTime, h.houseId, a.telephone, ha.isSellOn) from House as h, Agent as a, " +
                "District as d, Plot as p, HouseApplyer as ha where h.plotId = p.plotId and p.districtId = d.districtId" +
                " and p.agentId = a.agentId and ha.houseId = h.houseId and ha.houseApplyerId = " + userId;
        Query<HouseInfo> query = session.createQuery(hql);

        List<HouseInfo> houseInfoList = query.list();

        return houseInfoList;

    }

    @Override
    public List<ContractInfo> getContract(int houseId) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "select new model.ContractInfo(c.stime, c.etime, u1.name, u2.name, a.name, h.rent, h.area, " +
                "h.houseType, d.districtName, p.plotName, h.address, h.houseDescription, u2.telephone, u1.telephone) " +
                "from House as h, Plot as p, District as d, Agent as a, User as u1, User as u2, Contract as c where " +
                "h.plotId = p.plotId and p.districtId = d.districtId and p.agentId = a.agentId " +
                "and h.houseId = c.houseId and c.tenantId = u1.userId and h.landlordId = u2.userId and " +
                " c.houseId = " +houseId;

        Query<ContractInfo> query = session.createQuery(hql);

        List<ContractInfo> contractInfos = query.list();

        return contractInfos;
    }

    @Override
    public List<ContractInfo> getContractAsTenant(int houseId, int userId) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "select new model.ContractInfo(c.stime, c.etime, u1.name, u2.name, a.name, h.rent, h.area, " +
                "h.houseType, d.districtName, p.plotName, h.address, h.houseDescription, u2.telephone, u1.telephone) " +
                "from House as h, Plot as p, District as d, Agent as a, User as u1, User u2, Contract as c where " +
                "h.plotId = p.plotId and p.districtId = d.districtId and p.agentId = a.agentId " +
                "and h.houseId = c.houseId and c.tenantId = u1.userId and h.landlordId = u2.userId and " +
                " c.houseId = " +houseId + " and c.tenantId = " + userId;

        Query<ContractInfo> query = session.createQuery(hql);

        List<ContractInfo> contractInfos = query.list();

        return contractInfos;
    }

    @Override
    public List<OrderDisplay> getMyOutstandingOrders(int userId) {
        Session session = sessionFactory.getCurrentSession();

        /*String hql = "select new model.OrderDisplay(u1.name, u1.telephone, a.name, a.telephone, o.orderStime, " +
                "o.orderEtime, o.orderRent, o.orderId)" +
                " from Order as o, Agent as a, House as h, User as u1, User as u2, Plot as p where " +
                " o.houseId = h.houseId and h.landlordId = u1.userId and p.agentId = a.agentId and" +
                " p.plotId = h.plotId and o.applyerId = u2.userId and o.applyerId = " + userId;
        Query<Order> query = session.createQuery(hql);
        List<Order> orders = query.list();*/
        String sql = "select u2.telephone as landlordTel, a.name as agent, a.telephone as agentTel, o.order_stime,o.order_etime, h.rent, o.order_id " +
                "from `order` as o, agent as a, user u1, User u2, house as h, Plot as p where o.house_id = h.house_id  and p.agent_id = a.agent_id and " +
                "p.plot_id = h.plot_id and o.applyer_id = u1.user_id and h.landlord_id = u2.user_id and o.order_status = '0' and o.applyer_id = '" + userId + "';";

        SQLQuery query = session.createSQLQuery(sql);
        List orders = query.list();
        return orders;
    }

    @Override
    public List<OrderDisplay> getMyPrepaidOrders(int userId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "select u2.telephone as landlordTel, a.name as agent, a.telephone as agentTel, o.order_stime,o.order_etime, h.rent, o.order_id " +
                "from `order` as o, agent as a, user u1, User u2, house as h, Plot as p where o.house_id = h.house_id  and p.agent_id = a.agent_id and " +
                "p.plot_id = h.plot_id and o.applyer_id = u1.user_id and h.landlord_id = u2.user_id and o.order_status = '1' and o.applyer_id = '" + userId + "';";

        SQLQuery<OrderDisplay> query = session.createSQLQuery(sql);
        List<OrderDisplay> orders = query.list();
        return orders;
    }

    @Override
    public boolean modifyOrderStatus(int orderId) {
        Session session = sessionFactory.getCurrentSession();

        String sql0 = "select * from `order` where order_id = '" + orderId + "';";
        SQLQuery query0 = session.createSQLQuery(sql0).addEntity(Order.class);
        Order order = (Order)query0.uniqueResult();

        String sql1 = "insert into contract(stime, etime, tenant_id, house_id) values(?, ?, ?, ?);";
        SQLQuery query1 = session.createSQLQuery(sql1);
        query1.setParameter(1, order.getOrderStime());
        query1.setParameter(2, order.getOrderEtime());
        query1.setParameter(3, order.getApplyerId());
        query1.setParameter(4, order.getHouseId());
        query1.executeUpdate();

        String sql2 = "insert into house_applyer(house_id, house_applyer_id, isSellOn) values(?, ?, ?);";
        SQLQuery query2 = session.createSQLQuery(sql2);
        query2.setParameter(1,order.getHouseId()).setParameter(2, order.getApplyerId())
                .setParameter(3, (byte)1);
        query2.executeUpdate();

        String sql = "update `order` set order_status = '1' where order_id = '" + orderId + "';";
        session.createSQLQuery(sql).executeUpdate();



        return true;
    }

    @Override
    public User findUserByUserID(int userID){
        Session session =sessionFactory.getCurrentSession();
        SQLQuery query= session.createSQLQuery("select * from user where user_id = "+userID);
        query.addEntity(User.class);
        List<User> users = query.list();
        if (users == null)
            return null;
        return users.get(0);
    }

    @Override
    public List<User> findByName(String username) {
        List<User> users=findByProperty("name",username, "user");
        return users;
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
        Session session = sessionFactory.getCurrentSession();
        String hql = "update User set username= '" + user.getUsername() + "', name ='" +
                user.getName() + "', telephone = '" + user.getTelephone() + "', password ='" +
                user.getPassword() + "' where userId = " + user.getUserId();
        Query query = session.createQuery(hql);
        query.executeUpdate();
        return true;
    }
    @Override
    public boolean updateUser(User user, String newpassword) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Agent getAgentByPlot(int plotId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "select a.agent_id, a.telephone, a.name, a.password from Agent a, Plot p where p.agent_id=a.agent_id and p.plot_id = " + plotId;
        SQLQuery<Agent> query = session.createSQLQuery(sql).addEntity(Agent.class);
        Agent agent = query.uniqueResult();
        return agent;
    }

    @Override
    public boolean savehouse(LandlordApplyRelease landlordApplyRelease) {
        Session session= sessionFactory.getCurrentSession();
        try{

            //session.save(landlordApplyRelease);
            String sql = "insert into landlord_apply_release(applyer_id, " +
                    "address, expect_price, applyer_appellation, plot_id, applyer_phone) " +
                    "values(?, ?, ?, ?, ?, ?);";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1, landlordApplyRelease.getApplyerId())
                    .setParameter(2, landlordApplyRelease.getAddress())
                    .setParameter(3, landlordApplyRelease.getExpectPrice())
                    .setParameter(4, landlordApplyRelease.getApplyerAppellation())
                    .setParameter(5, landlordApplyRelease.getPlotId())
            .setParameter(6, landlordApplyRelease.getApplyerPhone());
            query.executeUpdate();
        }catch(HibernateException e){
            return false;
        }
        finally {
            //session.close();//关闭连接
        }
        return true;
    }
    @Override
    public boolean confirmHouse(House house,String phone, String user_name)
    {
        Session session= sessionFactory.getCurrentSession();
        try{

            int userid = getHouse_userid(phone);
            house.setLandlordId(userid);

            String sql = "insert into house(landlord_id, plot_id, " +
                    "address, rent, state, house_type, floor, area, " +
                    "house_description) values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1, house.getLandlordId())
                    .setParameter(2, house.getPlotId())
                    .setParameter(3, house.getAddress())
                    .setParameter(4, house.getRent())
                    .setParameter(5, house.getState())
                    .setParameter(6, house.getHouseType())
                    .setParameter(7, house.getFloor())
                    .setParameter(8, house.getArea())
                    .setParameter(9, house.getHouseDescription());
            query.executeUpdate();
            //session.save(house);

            User user = findUserByUserID(userid);

            if (user.getName() == null) {
                String sql2 = "insert into user(name) values(?) where user_id = '" + userid + "';";
                SQLQuery query2 = session.createSQLQuery(sql2);
                query2.setParameter(1, user_name);
                query2.executeUpdate();
            }




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

            //session.save(discussionSection);
            String sql = "insert into discussion_section(author_id, message) values(" +
                    "?, ?);";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1, discussionSection.getAuthorId())
                    .setParameter(2, discussionSection.getMessage());
            query.executeUpdate();

        }catch(HibernateException e){
            return false;
        }
        finally {
            //session.close();//关闭连接
        }
        return true;
    }


    public List getNotice()
    {
        Session session =sessionFactory.getCurrentSession();
        String sql = "select message,release_time,username from discussion_section,user where discussion_section.author_id=user.user_id order by release_time ASC limit 100 ";
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

    @Override
    public void saveAgent(Agent agent, int userId, String username) {
        Session session = sessionFactory.getCurrentSession();
        session.save(agent);

        addUserName(userId, username);

    }

    @Override
    public void addUserName(int userId, String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = findUserByUserID(userId);
        if (user.getName() != null) {
            String sql2 = "insert into user(name) values(?) where user_id = '" + userId + "';";
            SQLQuery query2 = session.createSQLQuery(sql2);
            query2.setParameter(1, username);
            query2.executeUpdate();
        }
    }

    public boolean getUserBYphone(String applyerTel){
        //根据applyerTel参数，查询对应的user表中的user.id
        //并返回user.id
        String sql="select * FROM tenement.user where telephone='"+applyerTel+"';";
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query=session.createSQLQuery(sql).addEntity(User.class);
        User user = (User)query.uniqueResult();
        if(user == null)
        {
            return false;

        }
        else
        {
            return true;
        }
    }
}
