package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class Logout extends ActionSupport {


    public String execute() throws Exception {
        Map<String, Object> user = ActionContext.getContext().getSession();
        user.clear();
        return "success";
    }

}
