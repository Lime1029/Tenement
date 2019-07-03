package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import service.UserService;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Register extends ActionSupport {

    private String telephone;
    private String password1;
    private String password2;
    private User user;
    private UserService userService;
    private String resultMess = "error";
    public String regMessage = null; //注册失败信息

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

    /*public void validate() {
        // 如果执行了addFieldError()或addActionError()等方法，则会转到input对应的页面
        if(this.getTelephone()==null||this.getTelephone().length()==0){
            addFieldError("telephone", "联系方式不能为空！");
        }else{
            if (userService.getUserByTel(this.getTelephone()) != null) {
                addFieldError("telephone", "用户已存在");
            }
        }
        if(this.getPassword1()==null||this.getPassword1().length()==0){
            addFieldError("password1", "密码不许为空！");
        }else if(this.getPassword2()==null||this.getPassword2().length()==0){
            addFieldError("password2", "确认密码不许为空！");
        }else if(!this.getPassword1().equals(this.getPassword2())){
            addFieldError("password2", "两次密码不一致！");
        }
    }*/

    public String execute() {

        String mobileExp =
                "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        Pattern p1 = Pattern.compile(mobileExp);
        Matcher m1 = p1.matcher(telephone);
        boolean isMobileMatch = m1.matches();

        String passwordExp = "^[a-z0-9_-]{6,15}$";
        Pattern p2 = Pattern.compile(passwordExp);
        Matcher m2 = p2.matcher(password1), m3 = p2.matcher(password2);
        boolean isPassword1Match = m2.matches(), isPassword2Match = m3.matches();

        if (!(isMobileMatch && isPassword1Match && isPassword2Match)) {
            regMessage = "手机号或密码格式错误";
        }
        else if (!password1.equals(password2)) {
            regMessage = "确认密码与密码不一致";
        }
        else {
            user.setTelephone(this.getTelephone());
            user.setPassword(this.getPassword1());
            /*ApplicationContext applicationContext = new
                    ClassPathXmlApplicationContext("spring-config.xml");
            userService = (UserService)applicationContext.getBean("userService");*/
            if (userService.getUserByTel(this.getTelephone()) != null) {
                regMessage = "用户已注册";
            }
            else {
                userService.save(user);
                //System.out.println("success");
                resultMess = "success";
            }
        }


        if (regMessage != null) {
            ActionContext.getContext().getSession().put("regMessage", regMessage);
        }

        return resultMess;
    }
}
