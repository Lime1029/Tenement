package action;

import com.opensymphony.xwork2.ActionSupport;
import service.UserService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GetAgentByPlot extends ActionSupport {
    private int plotId;
    private InputStream inputStream;
    private UserService userService;

    public int getPlotId() {
        return plotId;
    }

    public void setPlotId(int plotId) {
        this.plotId = plotId;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String execute() throws Exception {
        String str = "成功发送";
        inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
        userService.getAgentByPlot(plotId);
        return "success";
    }
}
