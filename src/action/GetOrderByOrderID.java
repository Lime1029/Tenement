package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import model.Order;
import service.OrderService;

public class GetOrderByOrderID extends ActionSupport{
    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private int orderID;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    private int start;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public String execute(){
        Order order = orderService.getOrderByOrderID(orderID);
        if(order==null) {
            return "zero";
        }
        ActionContext.getContext().getSession().put("orders",order);
        ActionContext.getContext().getSession().put("status", "id");
        return SUCCESS;
    }
}
