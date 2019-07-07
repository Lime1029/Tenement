package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import model.Order;
import model.User;
import model.House;
import service.OrderService;
import service.UserService;
import service.HouseService;

public class GetOrderDetail extends ActionSupport{
    private OrderService orderService;
    public void setOrderService(OrderService orderService){this.orderService = orderService;}
    public OrderService getOrderService(){return orderService;}
    private UserService userService;
    public void setUserService(UserService userService){this.userService = userService;}
    public UserService getUserService(){return userService;}
    private HouseService houseService;
    public void setHouseService(HouseService houseService){this.houseService = houseService;}
    public HouseService getHouseService(){return houseService;}
    private int orderID;
    public void setOrderID(int orderID){this.orderID = orderID;}
    public int getOrderID(){return orderID;}
    @Override
    public String execute(){
        Order order = orderService.getOrderByOrderID(orderID);
        if (order == null){
            return ERROR;
        }
        ActionContext.getContext().getSession().put("order", order);
        int landlordID = order.getLandlordId();
        User landlord = userService.findUserByUserID(landlordID);
        ActionContext.getContext().getSession().put("landlord", landlord);
        int applyerID = order.getApplyerId();
        User applyer = userService.findUserByUserID(applyerID);
        ActionContext.getContext().getSession().put("applyer", applyer);
        int houseID = order.getHouseId();
        House house = houseService.findHouseByHouseID(houseID);
        ActionContext.getContext().getSession().put("house", house);
        return SUCCESS;
    }
}
