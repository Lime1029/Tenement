package action;

import com.opensymphony.xwork2.ActionSupport;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import service.UserService;

@SuppressWarnings("serial")
public class Register extends ActionSupport {

    private String telephone;
    private String password1;
    private String password2;
    private User user;
    private UserService userService;
    private String mess = "error";

    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getPassword1() {
        return password1;
    }
    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    public String getPassword2() {
        return password2;
    }
    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void validate() {

    }

    public String execute() {
        user.setTelephone(this.getTelephone());
        user.setPassword(this.getPassword1());
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("spring-config.xml");
        userService = (UserService)applicationContext.getBean("userService");
        userService.save(user);
        System.out.println("success");
        mess = "success";
        return mess;
    }
}
