package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import model.Order;
import service.OrderService;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class GetOrderByDateRange extends ActionSupport{
    private List<Order> orders;
    private OrderService orderService;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    private String stime;

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getStime() {
        return stime;
    }

    private String etime;

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getEtime() {
        return etime;
    }

    private int start;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    private int last = 0;
    public int getLast(){return last;}
    public void setLast(int last){this.last = last;}
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String execute() throws Exception{
        orders = orderService.getOrderByDateRange(stime, etime,start, count);
        if(orders.size() == 0)
            return "zero";
        start++;
        last = start - 2;
        if(last < 0)
            last = 0;
        ActionContext.getContext().getSession().put("stime", stime);
        ActionContext.getContext().getSession().put("etime", etime);
        ActionContext.getContext().getSession().put("status", "date");
        ActionContext.getContext().getSession().put("start", start);
        ActionContext.getContext().getSession().put("last", last);
        ActionContext.getContext().getSession().put("count",1);
        ActionContext.getContext().getSession().put("orders", orders);
        return SUCCESS;
    }
}