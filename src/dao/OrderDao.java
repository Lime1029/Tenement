package dao;

import model.Order;

import java.util.Date;
import java.util.List;

public interface OrderDao {
    public List<Order> getAllOrder(int start, int count);
    public String deleteOrderByOrderID(int orderID);
    public Order getOrderByOrderID(int orderID);
    public List<Order> getOrderByAgentID(int agentID);
    public List<Order> getOrderByUserID(int userID);
    public List<Order> getOrderByDateRange(String stime, String etime, int start, int count);
    public int getCountByDateRange(String stime, String etime);
    public  int getCount();

    public List getMyOrder();
    public boolean saveOrder(Order order,String applyerTel,String applyerName);
    public void deleteOrderAgent(int orderId);
}