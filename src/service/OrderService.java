package service;

import model.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {
    public List<Order> getAllOrder(int start, int count);
    public String deleteOrderByOrderID(int orderID);
    public Order getOrderByOrderID(int orderID);
    public List<Order> getOrderByAgentID(int agentID);
    public List<Order> getOrderByUserID(int userID);
    public List<Order> getOrderByDateRange(String stime, String etime, int start, int count);

    List<Order> getMyOrders(int agentId);
    boolean saveOrder(Order order, String applyerTelephone,String applyerName);
}