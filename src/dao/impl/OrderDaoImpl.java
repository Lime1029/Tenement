package dao.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.OrderDao;
import model.*;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
@Transactional//事务注解
@Repository
public class OrderDaoImpl implements OrderDao {
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Order> getAllOrder(int start, int count){
        Session session =sessionFactory.getCurrentSession();
        SQLQuery query= session.createSQLQuery("select * from `order` limit "+start+","+count);
        query.addEntity(Order.class);
        List<Order> orders = query.list();
        return orders;
    }
    @Override
    public String deleteOrderByOrderID(int orderID){
        Session session =sessionFactory.getCurrentSession();
        SQLQuery query= session.createSQLQuery("delete from `order` where order_id = "+orderID);
        query.executeUpdate();
        return "success";
    }
    @Override
    public Order getOrderByOrderID(int orderID){
        Session session =sessionFactory.getCurrentSession();
        SQLQuery query= session.createSQLQuery("select * from `order` where order_id = "+orderID);
        query.addEntity(Order.class);
        List<Order> orders = query.list();
        if(orders.size() == 0)
            return null;
        Order order = orders.get(0);
        return order;
    }
    @Override
    public List<Order> getOrderByAgentID(int agentID){
        Session session =sessionFactory.getCurrentSession();
        SQLQuery query= session.createSQLQuery("select o.order_id, o.order_stime," +
                "o.order_etime, o.order_status, o.order_rent, o.order_etime, o.applyer_id, o.house_id from `order` o, House h," +
                "Plot p where o.house_id = h.house_id and h.plot_id = p.plot_id and " +
                " p.agent_id = "+agentID);
        query.addEntity(Order.class);
        List<Order> orders = query.list();
        return orders;
    }
    @Override
    public List<Order> getOrderByDateRange(String stime, String etime, int start, int count){
        Session session =sessionFactory.getCurrentSession();
        SQLQuery query= session.createSQLQuery("select * from `order` where order_stime >= '"+stime+"' and order_etime <= '"+etime+"' limit "+start+","+count);
        query.addEntity(Order.class);
        List<Order> orders = query.list();
        return orders;
    }
    @Override
    public List<Order> getOrderByUserID(int userID){
        Session session =sessionFactory.getCurrentSession();
        SQLQuery query= session.createSQLQuery("select * from `order` where applyer_id = "+userID);
        query.addEntity(Order.class);
        List<Order> orders = query.list();
        return orders;
    }
    @Override
    public int getCountByDateRange(String stime, String etime){
        Session session =sessionFactory.getCurrentSession();
        SQLQuery query= session.createSQLQuery("select count(*) from `order` where order_stime >= '"+stime+"' and order_etime <= '"+etime+"'");
        BigInteger count = new  BigInteger(""+query.uniqueResult());
        return count.intValue();
    }
    @Override
    public  int getCount(){
        Session session =sessionFactory.getCurrentSession();
        SQLQuery query= session.createSQLQuery("select count(*) from `order`");
        BigInteger count = new  BigInteger(""+query.uniqueResult());
        return  count.intValue();
    }


    @Override
    public boolean saveOrder(Order order,String applyerTel,String applyerName) {
        Agent agent = (Agent)ActionContext.getContext().getSession().get("agent");
        int agentId = agent.getAgentId();
        //查询houseId对应的House
        House house=checkHouseByAgentId(order,agentId);
        //查询applyerTelephone对应的userId
        User applyer=getApplyerIdByTel(applyerTel);


        if(applyer==null||house==null){
            return false;
        }else{
            int applyerId=applyer.getUserId();
            //附加：把jsp中写入的applyer姓名写入对应user_id,对应的user_name中。
            String sql0 = "select * from user where user_id = '" + applyerId + "';";
            SQLQuery<User> query0 = sessionFactory.getCurrentSession().createSQLQuery(sql0).addEntity(User.class);
            User user = query0.uniqueResult();
            if (user.getName() == null) {
                insertUserName(applyerName,applyerId);
            }
            //new一个新的order对象
            Order newOrder=new Order();
            newOrder.setHouseId(order.getHouseId());
            newOrder.setApplyerId(applyerId);
            newOrder.setOrderStime(order.getOrderStime());
            newOrder.setOrderEtime(order.getOrderEtime());
            newOrder.setOrderRent(order.getOrderRent());

            //读取order中的属性值，并重新封装到一个新的order里，
            //保存新的order到数据库
            Session session= sessionFactory.getCurrentSession();
            try{
                String sql="insert into `order`(order_stime, order_rent, order_etime, " +
                        "applyer_id, house_id) values(?, ?, ?, ?, ?);";
                SQLQuery query = session.createSQLQuery(sql);
                query.setParameter(1, newOrder.getOrderStime())
                        .setParameter(2, newOrder.getOrderRent())
                        .setParameter(3, newOrder.getOrderEtime())
                        .setParameter(4, newOrder.getApplyerId())
                        .setParameter(5, newOrder.getHouseId());
                query.executeUpdate();
            }catch(HibernateException e){
                return false;
            }
            finally {
                //session.close();
                // session会自己关闭，所以这里不需要关闭连接
            }
            return true;
        }
    }

    //按照order里的houseId和agentId查找该房源是否有效
    public House checkHouseByAgentId(Order order,int agentId){
        //直接使用houseId和agentId连表查询，该经纪人名下是否有此houseId对应的房源。
        String sql="select * from house h,agent a,plot p where h.plot_id=p.plot_id and p.agent_id=a.agent_id and h.house_id='"+order.getHouseId()+"'and a.agent_id='"+agentId+"';";
        Session session=sessionFactory.getCurrentSession();
        SQLQuery query=session.createSQLQuery(sql).addEntity(House.class);
        House house=(House)query.uniqueResult();
        return house;
    }

    public User getApplyerIdByTel(String applyerTel){
        //根据applyerTel参数，查询对应的user表中的user.id
        //并返回user.id
        String sql="select * FROM tenement.user where telephone='"+applyerTel+"';";
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query=session.createSQLQuery(sql).addEntity(User.class);
        User user = (User)query.uniqueResult();
        return user;
    }

    public void insertUserName(String applyerName,int userId){
        //根据applyerName参数，写入对应user表中的user.name,无返回值
        Session session=sessionFactory.getCurrentSession();
        String sql="UPDATE user SET name='"+applyerName+"'where user_id = '" + userId +"';";
        SQLQuery query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public List getMyOrder(){
        Agent agent = (Agent)ActionContext.getContext().getSession().get("agent");
        //使用sql查询语句
        String sql="SELECT o.order_id, o.order_stime, o.order_rent, o.order_status, o.order_etime, " +
                "o.applyer_id, o.house_id FROM `order` o, house h, plot p, agent a " +
                "where o.house_id = h.house_id and h.plot_id = p.plot_id and p.agent_id = a.agent_id and " +
                "a.agent_id='" + agent.getAgentId() +"';";
        Session session = sessionFactory.getCurrentSession();
        //将结果存入orders（列表）并返回orders列表
        SQLQuery query=session.createSQLQuery(sql);
        List orders=query.list();
        return orders;
    }

    @Override
    public void deleteOrderAgent(int orderId){
        //根据传入的order，update数据库里的订单数据
        System.out.println(orderId);
        Session session=sessionFactory.getCurrentSession();
        String sql="DELETE FROM `order` WHERE order_id="+ orderId;
        SQLQuery query = session.createSQLQuery(sql);
        query.executeUpdate();
    }
}