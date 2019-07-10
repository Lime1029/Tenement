package service.impl;

import com.opensymphony.xwork2.ActionContext;
import model.Order;
import service.OrderService;
import org.springframework.stereotype.Service;
import dao.OrderDao;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService{
    private OrderDao orderDao;
    public OrderDao getOrderDao(){return orderDao;}
    public void setOrderDao(OrderDao orderDao){this.orderDao = orderDao;}
    @Override
    public List<Order> getAllOrder(int start, int count){
        List<Order> orders = orderDao.getAllOrder(start, count);
        return orders;
    }
    @Override
    public String deleteOrderByOrderID(int orderID){
        String isDelete = orderDao.deleteOrderByOrderID(orderID);
        return isDelete;
    }
    @Override
    public Order getOrderByOrderID(int orderID){
        Order order = orderDao.getOrderByOrderID(orderID);
        return order;
    }
    @Override
    public List<Order> getOrderByAgentID(int agentID){
        List<Order> orders = orderDao.getOrderByAgentID(agentID);
        return orders;
    }
    @Override
    public List<Order> getOrderByDateRange(String stime, String etime, int start, int count){
        List<Order> orders = orderDao.getOrderByDateRange(stime, etime, start, count);
        return orders;
    }
    @Override
    public List<Order> getOrderByUserID(int userID) {
        List<Order> orders = orderDao.getOrderByUserID(userID);
        return orders;
    }
    @Override
    public int getCountByDateRange(String stime, String etime){
        return orderDao.getCountByDateRange(stime, etime);
    }
    @Override
    public int  getCount(){
        return orderDao.getCount();
    }



    @Override
    public List<Order> getMyOrders(int agentId){
        List<Order> orders=orderDao.getMyOrder(agentId);
        ActionContext.getContext().getSession().put("orders", orders);
        return orders;
    }

    @Override
    public boolean saveOrder(Order order, String applyerTelephone,String applyerName){
        return  orderDao.saveOrder(order,applyerTelephone,applyerName);
    }


}