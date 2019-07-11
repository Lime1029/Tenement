package action;

import com.opensymphony.xwork2.ActionContext;
import model.User;
import service.UserService;

public class UserQuery {
    private String resultMess = "error";
    private UserService userService;
    private int userId;
    private int houseId;
    private int orderId;
    private User user;
    private String paymentMessage = null;


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String searchHouseInMyName() throws Exception {

        userService.searchMyHouse(userId);
        resultMess = "success";
        return resultMess;
    }

    public String searchMyRentalHouse() throws Exception {

        userService.searchMyRentalHouse(userId);
        resultMess = "success";

        return resultMess;
    }

    public String getMyContract() throws Exception {
        userService.getMyContract(houseId);
        resultMess = "success";

        return resultMess;

    }

    public String getContractAsTenant() throws Exception {
        userService.getContractAsTenant(houseId, userId);
        return "success";
    }

    public String getMyOrders() throws Exception {
        userService.getMyOutstandingOrders(userId);
        //userService.getMyPrepaidOrders(userId);
        return "success";
    }

    public String modifyOrderStatus() throws Exception {
        userService.modifyOrderStatus(orderId);
        paymentMessage = "支付成功";
        ActionContext.getContext().getSession().put("paymentMessage", paymentMessage);
        if (paymentMessage != null) {
            System.out.println(paymentMessage);
        }

        return "success";
    }

    public String updateUser() throws Exception {
        userService.modifyUser(user);
        ActionContext.getContext().getSession().put("user", user);
        return "success";
    }

}
