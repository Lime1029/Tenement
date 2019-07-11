package action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import model.LandlordApplyRelease;
import model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import service.UserService;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Map;


public class HouseSubmit extends ActionSupport{
    private LandlordApplyRelease landlordApplyRelease;
    private User user;
    private Integer applyer_id;
    private String address;
    private Integer plot_id;
    private Double price;
    private String phone;
    private String appellation;
    private String resultMess = "error";
    public String submitMessage = null; //��¼ʧ����Ϣ
    private UserService userService;


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Integer getApplyer_id() {
        return applyer_id;
    }

    public void setApplyer_id(Integer applyer_id) {
        this.applyer_id = applyer_id;
    }

    public Integer getPlot_id() {
        return plot_id;
    }

    public void setPlot_id(Integer plot_id) {
        this.plot_id = plot_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getResultMess() {
        return resultMess;
    }

    public void setResultMess(String resultMess) {
        this.resultMess = resultMess;
    }

    public String getSubmitMessage() {
        return submitMessage;
    }

    public void setSubmitMessage(String submitMessage) {
        this.submitMessage = submitMessage;
    }

    public LandlordApplyRelease getLandlordApplyRelease() {
        return landlordApplyRelease;
    }

    public void setLandlordApplyRelease(LandlordApplyRelease landlordApplyRelease) {
        this.landlordApplyRelease = landlordApplyRelease;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute() {


            //System.out.println("success");

            landlordApplyRelease.setAddress(this.getAddress());
            landlordApplyRelease.setApplyerAppellation(this.getAppellation());
            landlordApplyRelease.setApplyerId(this.getApplyer_id());
            landlordApplyRelease.setApplyerPhone(this.getPhone());
            landlordApplyRelease.setExpectPrice(this.getPrice());
            landlordApplyRelease.setPlotId(this.getPlot_id());
            userService.savehouse(landlordApplyRelease);
            resultMess = "success";



        return resultMess;


    }
}