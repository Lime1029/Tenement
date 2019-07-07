package service;

import model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getMyOrders(int agentId);

    boolean saveOrder(Order order, String applyerTelephone,String applyerName);

}