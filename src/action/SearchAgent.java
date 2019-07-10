package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import model.Order;
import service.OrderService;
import model.Agent;
import service.AgentService;

import java.util.ArrayList;
import java.util.List;

public class SearchAgent extends ActionSupport{
    private OrderService orderService;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    private AgentService agentService;

    public AgentService getAgentService() {
        return agentService;
    }

    public void setAgentService(AgentService agentService) {
        this.agentService = agentService;
    }

    private String agentInfo;

    public String getAgentInfo() {
        return agentInfo;
    }

    public void setAgentInfo(String agentInfo) {
        this.agentInfo = agentInfo;
    }
    @Override
    public String execute(){
    try{
        int agentID = Integer.parseInt(agentInfo);
        List<Order> orders = orderService.getOrderByAgentID(agentID);
        if(orders.size() == 0)
            return ERROR;
        ActionContext.getContext().getSession().put("orders",orders);
        return SUCCESS;
    }
    catch(NumberFormatException nff){
        List<Agent> agents = agentService.getAgentByAgentName(agentInfo);
        if(agents.size() == 0)
            return ERROR;
        List<Order> orders = new ArrayList<>();
        for (int i=0;i<agents.size();i++){
            List<Order> ordersByName = orderService.getOrderByAgentID(agents.get(i).getAgentId());
            for (int j=0;j<ordersByName.size();j++){
                Order orderByName = ordersByName.get(j);
                orders.add(orderByName);
            }
        }
        ActionContext.getContext().getSession().put("orders",orders);
        ActionContext.getContext().getSession().put("status", "agent");
        return SUCCESS;
    }
}

}
