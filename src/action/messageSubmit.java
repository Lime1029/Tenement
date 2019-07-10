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

public class messageSubmit extends ActionSupport{
    private String Message;
    private DiscussionSection discussionSection;
    private Integer author_id;
    private UserService userService;
    private User user;


    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public UserService getUserService() {
        return userService;
    }

    public DiscussionSection getDiscussionSection() {
        return discussionSection;
    }

    public void setDiscussionSection(DiscussionSection discussionSection) {
        this.discussionSection = discussionSection;
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

    @Override
    public String execute() throws Exception {
        String forward = "error";//数据库存数据时出错标记值
        int flag = 0;



        if (user != null) {
            discussionSection = new DiscussionSection();
            discussionSection.setAuthorId(this.getAuthor_id());
            discussionSection.setMessage(this.getMessage());
            userService.messageSubmit(discussionSection);
            forward="success";
            if (forward != null) {
                ActionContext.getContext().getSession().put("forward", forward);
            }

            return forward;




        }
        return forward;
    }
}