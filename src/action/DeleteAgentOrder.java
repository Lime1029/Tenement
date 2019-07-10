package action;

import service.OrderService;

public class DeleteAgentOrder {
    private OrderService orderService;
    private int orderId;
    private int agentId;

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public String execute(){
        System.out.println(orderId);
        orderService.deleteOrderAgent(orderId);
        return "success";
    }
}
