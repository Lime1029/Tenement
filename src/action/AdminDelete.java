package action;

import com.opensymphony.xwork2.ActionSupport;
import service.AdminService;

public class AdminDelete extends ActionSupport {
    private String resultMess = "error";
    private int userId;
    private int agentId;
    private int houseId;
    private int cityId;
    private int plotId;
    private int districtId;
    private AdminService adminService;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getPlotId() {
        return plotId;
    }

    public void setPlotId(int plotId) {
        this.plotId = plotId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }


    public String deleteUser() throws Exception {

        adminService.deleteUser(userId);
        resultMess = "success";

        return resultMess;
    }

    public String deleteAgent() throws Exception {
        adminService.deleteAgent(agentId);
        resultMess = "success";

        return resultMess;
    }

    public String deleteHouse() throws Exception {
        adminService.deleteHouse(houseId);
        return "success";
    }

    public String deleteCity() throws Exception {
        adminService.deleteCity(cityId);
        return "success";
    }

    public String deleteDistrict() throws Exception {
        adminService.deleteDistrict(districtId);
        return "success";
    }

    public String deletePlot() throws Exception {
        adminService.deletePlot(plotId);
        return "success";
    }
}
