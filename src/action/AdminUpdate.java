package action;

import com.opensymphony.xwork2.ActionSupport;
import service.AdminService;

public class AdminUpdate extends ActionSupport {
    private AdminService adminService;
    private int cityId;
    private String cityName;
    private int districtId;
    private String districtName;

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }



    public String modifyCity() throws Exception {
        adminService.modifyCity(cityId, cityName);

        return "success";
    }

    public String modifyDistrict() throws Exception {
        adminService.modifyDistrict(cityId, districtId, districtName);

        return "success";
    }
}
