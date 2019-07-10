package action;

import com.opensymphony.xwork2.ActionSupport;
import model.User;
import service.AdminService;

public class AdminDisplay extends ActionSupport {

    private String resultMess = "error";
    private AdminService adminService;

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public String userDisplay() throws Exception {


        adminService.getAllUsers();
        resultMess = "success";
        return resultMess;
    }

    public String agentDisplay() throws Exception {
        adminService.getAllAgents();
        resultMess = "success";
        return resultMess;
    }

    public String houseDisplay() throws Exception {
        adminService.getAllHouses();
        return "success";
    }

    public String cityDisplay() throws Exception {
        adminService.getAllCities();
        return "success";
    }

    public String districtDisplay() throws Exception {
        adminService.getAllDistricts();
        return "success";
    }

    public String plotDisplay() throws Exception {
        adminService.getAllPlots();
        return "success";
    }

}
