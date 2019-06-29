package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import model.Administrator;
import model.Agent;
import model.User;
import service.UserService;

public class Login extends ActionSupport {
    private User user;
    private Administrator administrator;
    private Agent agent;
    private String telephone;
    private String password;
    private String role;
    private UserService userService;
    private String mess = "error";


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
        if (role.equals("user")) {
            user =userService.getUserByTel(telephone);
            if(user !=null&& user.getPassword().equals(password)){
                //System.out.println("success");
                ActionContext actionContext=ActionContext.getContext();
                actionContext.getSession().put("user", user);
                mess = "user";
            }
        }
        else if (role.equals("agent")) {
            agent = userService.getAgentByTel(telephone);
            if (agent != null && agent.getPassword().equals(password)) {
                ActionContext actionContext=ActionContext.getContext();
                actionContext.getSession().put("agent", agent);
                mess = "agent";
            }
        }
        else {
            administrator = userService.getAdminByTel(telephone);
            if (administrator != null && administrator.getPassword().equals(password)) {
                ActionContext actionContext=ActionContext.getContext();
                actionContext.getSession().put("admin", administrator);
                mess = "admin";
            }
        }


        return mess;
    }

}
