package dao.impl;

import dao.OrderDao;
import model.Order;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import model.Chat;
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
        SQLQuery query= session.createSQLQuery("select * from `order` where agent_id = "+agentID);
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
}
