package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import model.Order;
import service.OrderService;
import model.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class SearchOrderByUserInfo extends ActionSupport{
    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    private String userInfo;

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getUserInfo() {
        return userInfo;
    }
    
    @Override
    public String execute(){
        try{
            int userID = Integer.parseInt(userInfo);
            List<Order> orders = orderService.getOrderByUserID(userID);
            if(orders.size() == 0)
                return ERROR;
            ActionContext.getContext().getSession().put("orders",orders);
            return SUCCESS;
        }
        catch(NumberFormatException nff){
            List<User> users = userService.getUserByLoginName(userInfo);
            if(users.size() == 0)
                return ERROR;
            List<Order> orders = new ArrayList<>();
            for (int i=0;i<users.size();i++){
                List<Order> ordersByName = orderService.getOrderByUserID(users.get(i).getUserId());
                for (int j=0;j<ordersByName.size();j++){
                    Order orderByName = ordersByName.get(j);
                    orders.add(orderByName);
                }
            }
            ActionContext.getContext().getSession().put("orders",orders);
            return SUCCESS;
        }
    }
}
