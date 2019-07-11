package action;

import com.opensymphony.xwork2.ActionSupport;
import model.Order;
import service.OrderService;

import java.sql.Date;

//将order对象保存至数据库
public class AddOrder extends ActionSupport {
    private OrderService orderService;
    private Order order;
    private int houseId;
    private Date orderStime;
    private Date orderEtime;
    private int orderRent;
    private String applyerTel;
    private String applyerName;

    private String resultMess="error";

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getHouseId() {
        return houseId;
    }

    public Date getOrderStime() {
        return orderStime;
    }

    public void setOrderStime(Date orderStime) {
        this.orderStime = orderStime;
    }

    public Date getOrderEtime() {
        return orderEtime;
    }

    public void setOrderEtime(Date orderEtime) {
        this.orderEtime = orderEtime;
    }

    public int getOrderRent() {
        return orderRent;
    }

    public void setOrderRent(int orderRent) {
        this.orderRent = orderRent;
    }

    //单独传值的电话号码属性+姓名属性
    public String getApplyerTel() {
        return applyerTel;
    }

    public void setApplyerTel(String applyerTelephone) {
        this.applyerTel = applyerTelephone;
    }

    public String getApplyerName() {
        return applyerName;
    }

    public void setApplyerName(String applyerName) {
        this.applyerName = applyerName;
    }

    @Override
    public String execute() throws Exception {
        resultMess="error";
        boolean flag=orderService.saveOrder(order,applyerTel,applyerName);//返回的是一个boolean值：true/false
        if(flag==true){
            resultMess="success";
            return resultMess;
        }else{
            return resultMess;
        }
    }
}