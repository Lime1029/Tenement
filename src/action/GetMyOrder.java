package action;

import com.opensymphony.xwork2.ActionSupport;

import service.OrderService;


//用于操作以获取当前session中保存的agentId并查找其名下order
public class GetMyOrder extends ActionSupport {

    private String resultMess="error";
    private OrderService orderService;
    private int agentId;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String execute() throws Exception{
        //从session中获取当前agentId
        //现在未整合所以先写死
        orderService.getMyOrders(agentId);
        resultMess="success";
        return resultMess;
    }
}