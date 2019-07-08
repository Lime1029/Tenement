package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import model.Order;
import service.OrderService;

import java.util.List;
public class GetAllOrder extends ActionSupport{
    private List<Order> orders;
    private OrderService orderService;
    public void setOrderService(OrderService orderService){this.orderService = orderService;}
    public OrderService getOrderService(){return orderService;}
    private int start = 0;
    public int getStart() { return start; }
    public void setStart(int start) { this.start = start; }
    private int last = 0;
    public int getLast(){return last;}
    public void setLast(int last){this.last = last;}
    private int count;
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    @Override
    public String execute(){
        String status =  SUCCESS;
        orders = orderService.getAllOrder(start, count);
        if(orders.size() == 0){
            status = "zero";
        }
        start++;
        last = start - 2;
        if(last < 0)
            last = 0;
        ActionContext.getContext().getSession().put("status", "all");
        ActionContext.getContext().getSession().put("start", start);
        ActionContext.getContext().getSession().put("last", last);
        ActionContext.getContext().getSession().put("count",1);
        ActionContext.getContext().getSession().put("orders", orders);
        return status;
    }
}