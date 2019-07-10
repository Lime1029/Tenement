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
    private int input_start = 0;

    public void setInput_start(int input_start) {
        this.input_start = input_start;
    }

    public int getInput_start() {
        return input_start;
    }

    private int last = 0;
    public int getLast(){return last;}
    public void setLast(int last){this.last = last;}
    private int count;
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    @Override
    public String execute(){
        int countOfOrder = orderService.getCount();
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
        String status =  SUCCESS;
        orders = orderService.getAllOrder(start, count);
        start++;
        last = start - 2;
        if(last < 0)
            ActionContext.getContext().getSession().put("isLastPage", "n");
        else{
            ActionContext.getContext().getSession().put("isLastPage","y");
        }
        ActionContext.getContext().getSession().put("status", "all");
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
        return status;
    }
}