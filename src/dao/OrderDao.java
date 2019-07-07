package dao;

import model.Order;

import java.util.List;

public interface OrderDao {

    List<Order> getMyOrder(int agentId);

    boolean saveOrder(Order order,String applyerTelephone,String applyerName);
}