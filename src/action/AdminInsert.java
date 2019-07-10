package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Agent;
import model.City;
import model.District;
import model.Plot;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.annotations.Parent;
import service.AdminService;
import service.UserService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;


public class AdminInsert extends ActionSupport {
    private AdminService adminService;
    private String agentName;
    private String agentTelephone;
    private String agentPassword;
    private Agent agent;
    private String cityName;
    private City city;
    private String districtName;
    private int cityId;
    private District district;
    private String plotName;
    private int districtId;
    private int agentId;
    private Plot plot;
    private UserService userService;
    private String adminMessage = null;
    private String resultMess = "error";

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public String getAgentPassword() {
        return agentPassword;
    }

    public void setAgentPassword(String password) {
        this.agentPassword = password;
    }


    public String getAgentTelephone() {
        return agentTelephone;
    }

    public void setAgentTelephone(String telephone) {
        this.agentTelephone = telephone;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String name) {
        this.agentName = name;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String insertAgent() throws Exception {
        agent.setName(agentName);
        agent.setTelephone(agentTelephone);
        agent.setPassword(agentPassword);

        if (userService.getAgentByTel(agentTelephone) != null) {

            adminMessage = "用该手机号注册的用户已存在";
        }
        else {
            adminService.save(agent);
            resultMess = "success";
        }

        if (adminMessage != null) {
            ActionContext.getContext().getSession().put("adminMessage", adminMessage);
        }
        return resultMess;

    }

    public String insertCity() throws Exception {
        city.setName(cityName);

        if (adminService.getCityByName(cityName) != null) {
            adminMessage = "该城市名已被注册";
        }
        else {
            adminService.save(city);
            resultMess = "success";
        }

        if (adminMessage != null) {
            ActionContext.getContext().getSession().put("adminMessage", adminMessage);
        }

        return resultMess;
    }

    public String insertDistrict() throws Exception {
        //System.out.println(districtName);

        district.setDistrictName(districtName);
        district.setCityId(cityId);
        if (adminService.getDistrictByName(districtName) != null) {
            adminMessage = "该区域名已被注册";
        }
        else {
            adminService.save(district);
            resultMess = "success";
        }

        if (adminMessage != null) {
            ActionContext.getContext().getSession().put("adminMessage", adminMessage);
        }

        return resultMess;
    }

    public String insertPlot() throws Exception {
        plot.setDistrictId(districtId);
        plot.setPlotName(plotName);
        plot.setAgentId(agentId);

        if (adminService.getPlotBySome(plotName, districtId) != null) {
            adminMessage = "同一区域下该小区名已被注册";
        }
        else {
            adminService.save(plot);
            resultMess = "success";
        }

        if (adminMessage != null) {
            ActionContext.getContext().getSession().put("adminMessage", adminMessage);
        }

        return resultMess;

    }

}
