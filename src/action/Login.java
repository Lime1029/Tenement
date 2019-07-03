package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import model.Administrator;
import model.Agent;
import model.User;
import service.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends ActionSupport {
    private User user;
    private Administrator administrator;
    private Agent agent;
    private String telephone;
    private String password;
    private String role;
    private UserService userService;
    private String resultMess = "error";
    public String loginMessage = null; //登录失败信息


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void validate() {

    }

    public String execute() throws Exception {

        String mobileExp =
                "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        Pattern p1 = Pattern.compile(mobileExp);
        Matcher m1 = p1.matcher(telephone);  //registrant_phone  ====  电话号码字段
        boolean isMobileMatch = m1.matches();

        String passwordExp = "^[a-z0-9_-]{6,15}$";
        Pattern p2 = Pattern.compile(passwordExp);
        Matcher m2 = p2.matcher(password);
        boolean isPasswordMatch = m2.matches();

        if (!(isMobileMatch && isPasswordMatch)) {
            loginMessage = "手机号或密码格式错误";
        }
        else {
            if (role.equals("user")) {
                user =userService.getUserByTel(telephone);
                if (user == null) {
                    loginMessage = "用户不存在";

                }
                else if(user.getPassword().equals(password)){
                    //System.out.println("success");
                    ActionContext actionContext=ActionContext.getContext();
                    actionContext.getSession().put("user", user);
                    resultMess = "user";
                }
                else {
                    loginMessage = "登录密码错误";
                }
            }

            else if (role.equals("agent")) {
                agent = userService.getAgentByTel(telephone);
                if (agent == null) {
                    loginMessage = "用户不存在";
                }
                else if (agent.getPassword().equals(password)) {
                    ActionContext actionContext=ActionContext.getContext();
                    actionContext.getSession().put("agent", agent);
                    resultMess = "agent";
                }
                else {
                    loginMessage = "登陆密码错误";
                }
            }

            else {
                administrator = userService.getAdminByTel(telephone);
                if (administrator == null) {
                    loginMessage = "用户不存在";
                }
                else if (administrator.getPassword().equals(password)) {
                    ActionContext actionContext=ActionContext.getContext();
                    actionContext.getSession().put("admin", administrator);
                    resultMess = "admin";
                }
                else {
                    loginMessage = "登陆密码错误";
                }
            }
        }



        ActionContext.getContext().getSession().put("loginMessage", loginMessage); //将登录失败信息存到session里
        return resultMess;
    }

}
