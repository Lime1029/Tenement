package action;

import com.opensymphony.xwork2.ActionSupport;
import model.User;
import service.AdminService;

public class UserDisplay extends ActionSupport {

    private String resultMess = "error";
    private AdminService adminService;

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public String execute() throws Exception {


        adminService.getAllUsers();
        resultMess = "success";
        return resultMess;
    }

}
