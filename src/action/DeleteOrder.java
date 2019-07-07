package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import model.Order;
import service.OrderService;

import java.util.List;

public class DeleteOrder extends ActionSupport{
    private OrderService orderService;
    public void setOrderService(OrderService orderService){this.orderService = orderService;}
    public OrderService getOrderService(){return orderService;}
    private int orderID;
    public void setOrderID(int orderID){this.orderID = orderID;}
    public int getOrderID(){return orderID;}
    @Override
    public String execute(){
        String isDelete = orderService.deleteOrderByOrderID(orderID);
        List<Order> orders = orderService.getAllOrder(0,10);
        if(orders.size() == 0)
            return "zero";
        return SUCCESS;
    }
}
