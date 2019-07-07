package service.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.OrderDao;
import model.Order;
import org.springframework.stereotype.Service;
import service.OrderService;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
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
