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

    private int input_start;

    public void setInput_start(int input_start) {
        this.input_start = input_start;
    }

    public int getInput_start() {
        return input_start;
    }

    private int last = 1;
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
        int countOfOrder = orderService.getCountByDateRange(stime, etime);
        int countOfPage = 0;
        if (countOfOrder%count == 0){
            countOfPage = countOfOrder/count;
        }
        else{
            countOfPage = (int)(countOfOrder/count)+1;
        }
        if(input_start != 0){
            start = input_start -1;
            input_start = 0;
        }
        if(countOfPage <= start){
            ActionContext.getContext().getSession().put("isNextPage", "n");
            return "zero";
        }
        orders = orderService.getOrderByDateRange(stime, etime, start, count);
        start++;
        last = start - 2;
        if(last < 0){
            ActionContext.getContext().getSession().put("isLastPage", "n");
        }
        else{
            ActionContext.getContext().getSession().put("isLastPage","y");
        }
        ActionContext.getContext().getSession().put("stime", stime);
        ActionContext.getContext().getSession().put("etime", etime);
        ActionContext.getContext().getSession().put("status", "date");
        ActionContext.getContext().getSession().put("start", start);
        ActionContext.getContext().getSession().put("last", last);
        ActionContext.getContext().getSession().put("count",1);
        ActionContext.getContext().getSession().put("orders", orders);
        if(countOfPage <= start){
            ActionContext.getContext().getSession().put("isNextPage","n");
        }
        else{
            ActionContext.getContext().getSession().put("isNextPage","y");
        }
        ActionContext.getContext().getSession().put("page",countOfPage);
        return SUCCESS;
    }
}
