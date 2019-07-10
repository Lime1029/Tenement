package dao.impl;

import dao.OrderDao;
import model.Order;
import model.User;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import model.Chat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public boolean saveOrder(Order order,String applyerTelephone,String applyerName) {
        //查询applyerTelephone对应的userId
        int applyerId=getApplyerIdByTel(applyerTelephone);
        //附加：把jsp中写入的applyer姓名写入对应user_id,对应的user_name中。
        String sql0 = "select * from user where user_id = '" + applyerId + "';";
        SQLQuery<User> query0 = sessionFactory.getCurrentSession().createSQLQuery(sql0);
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

    public int getApplyerIdByTel(String applyerTelephone){
        //根据applyerTelephone参数，查询对应的user表中的user.id
        //并返回user.id
        String sql="select * FROM tenement.user where telephone='"+applyerTelephone+"';";
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query=session.createSQLQuery(sql).addEntity(User.class);
        User user = (User)query.uniqueResult();
        int userId=user.getUserId();
        return userId;
    }

    public void insertUserName(String applyerName,int userId){
        //根据applyerName参数，写入对应user表中的user.name,无返回值
        Session session=sessionFactory.getCurrentSession();
        String sql="UPDATE user SET name='"+applyerName+"'where user_id = '" + userId +"';";
        SQLQuery query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public List<Order> getMyOrder(int agentId){

        //使用sql查询语句
        String sql="SELECT o.order_id, o.order_stime, o.order_rent, o.order_status, o.order_etime, " +
                "o.applyer_id, o.house_id FROM `order` o, house h, plot p, agent a " +
                "where o.house_id = h.house_id and h.plot_id = p.plot_id and p.agent_id = a.agent_id and " +
                "a.agent_id='" + agentId +"';";
        Session session = sessionFactory.getCurrentSession();
        //将结果存入orders（列表）并返回orders列表
        SQLQuery<Order> query=session.createSQLQuery(sql);
        List<Order> orders=query.list();
        return orders;
    }
}