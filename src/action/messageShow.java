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
import model.DiscussionSection;

public class messageShow {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public String execute() throws Exception {
        String forward = "success";
        userService.messageSave();
        return forward;
    }
}
