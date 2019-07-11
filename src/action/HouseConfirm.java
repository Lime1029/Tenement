package action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import dao.UserDao;
import model.LandlordApplyRelease;
import model.User;
import model.House;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import service.OrderService;
import service.UserService;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Map;

public class HouseConfirm extends ActionSupport {
    private House house;
    private Integer landlord_id;
    private Integer plot_id;
    private String house_address;
    private Double house_rent;
    private Integer house_state;
    private String house_type;
    private String house_floor;
    private Double house_area;
    private String house_description;
    private String resultMess = "error";
    private UserService userService;
    private String user_phone;
    private String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public Integer getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(Integer landlord_id) {
        this.landlord_id = landlord_id;
    }

    public Integer getPlot_id() {
        return plot_id;
    }

    public void setPlot_id(Integer plot_id) {
        this.plot_id = plot_id;
    }

    public String getHouse_address() {
        return house_address;
    }

    public void setHouse_address(String house_address) {
        this.house_address = house_address;
    }

    public Double getHouse_rent() {
        return house_rent;
    }

    public void setHouse_rent(Double house_rent) {
        this.house_rent = house_rent;
    }

    public Integer getHouse_state() {
        return house_state;
    }

    public void setHouse_state(Integer house_state) {
        this.house_state = house_state;
    }

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }

    public String getHouse_floor() {
        return house_floor;
    }

    public void setHouse_floor(String house_floor) {
        this.house_floor = house_floor;
    }

    public Double getHouse_area() {
        return house_area;
    }

    public void setHouse_area(Double house_area) {
        this.house_area = house_area;
    }

    public String getHouse_description() {
        return house_description;
    }

    public void setHouse_description(String house_description) {
        this.house_description = house_description;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String execute() {
        String forward = "error";//���ݿ������ʱ������ֵ
        boolean flag = false;
        boolean phone_flag = false;
        house.setAddress(this.house_address);
        house.setArea(this.house_area);
        house.setFloor(this.house_floor);
        house.setHouseDescription(this.house_description);
        house.setHouseType(this.house_type);
        house.setRent(this.house_rent);
        house.setPlotId(this.plot_id);
        house.setState(this.house_state);
        phone_flag = userService.getUserByphone(user_phone);
        if(phone_flag)
        {
            flag = userService.confirmHouse(house,user_phone, user_name);
            if (flag) {
                forward = "success";

            }
        }
        else
        {
            forward = "phone_error";
        }





        ActionContext.getContext().getSession().put("regMessage", forward);
        return forward;
    }
}
