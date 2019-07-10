package service.impl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.AdminDao;
import model.*;
import org.springframework.stereotype.Service;
import service.AdminService;

import java.util.List;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao;

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = adminDao.getAllUsers();
        ActionContext.getContext().getSession().put("users", users);
        return users;
    }

    @Override
    public void deleteUser(int userId) {
        adminDao.deleteUser(userId);
    }

    @Override
    public List<Agent> getAllAgents() {
        List<Agent> agents = adminDao.getAllAgents();
        ActionContext.getContext().getSession().put("agents", agents);

        return agents;
    }

    @Override
    public void deleteAgent(int agentId) {
        adminDao.deleteAgent(agentId);
    }

    @Override
    public boolean save(Agent agent) {
        return adminDao.save(agent);
    }

    @Override
    public List<HouseInfo> getAllHouses() {
        List<HouseInfo> houses = adminDao.getAllHouses();
        ActionContext.getContext().getSession().put("adminHouses", houses);

        return houses;
    }

    @Override
    public void deleteHouse(int houseId) {
        adminDao.deleteHouse(houseId);
    }

    @Override
    public List<City> getAllCities() {
        List<City> cities = adminDao.getAllCities();
        ActionContext.getContext().getSession().put("cities", cities);

        return cities;
    }

    @Override
    public boolean modifyCity(int cityId, String cityName) {
        return adminDao.modifyCity(cityId, cityName);
    }

    @Override
    public boolean save(City city) {
        return adminDao.save(city);
    }

    @Override
    public void deleteCity(int cityId) {
        adminDao.deleteCity(cityId);
    }

    @Override
    public List getAllDistricts() {
        List districts = adminDao.getAllDistricts();
        ActionContext.getContext().getSession().put("districts", districts);
        List<City> cities = adminDao.getAllCities();
        ActionContext.getContext().getSession().put("disCities", cities);
        return districts;
    }

    @Override
    public boolean modifyDistrict(int cityId, int districtId, String districtName) {
        return adminDao.modifyDistrict(cityId, districtId, districtName);
    }

    @Override
    public boolean save(District district) {
        return adminDao.save(district);
    }

    @Override
    public void deleteDistrict(int districtId) {
        adminDao.deleteDistrict(districtId);
    }

    @Override
    public List getAllPlots() {
        List plots = adminDao.getAllPlots();
        ActionContext.getContext().getSession().put("plots", plots);
        List<City> cities = adminDao.getAllCities();
        ActionContext.getContext().getSession().put("plotCities", cities);
        List districts = adminDao.getAllDistricts();
        ActionContext.getContext().getSession().put("plotDistricts", districts);
        List<Agent> agents = adminDao.getAllAgents();
        ActionContext.getContext().getSession().put("plotAgents", agents);

        return plots;
    }

    @Override
    public void deletePlot(int plotId) {
        adminDao.deletePlot(plotId);
    }

    @Override
    public boolean modifyPlot(int plotId, int districtId, int agentId, String plotName) {
        return adminDao.modifyPlot(plotId, districtId, agentId, plotName);
    }

    @Override
    public List getDistrictByCity(int cityId) {
        List districts = adminDao.getDistrictByCity(cityId);


        //ActionContext.getContext().getSession().put("plotDistricts", districts);

        return districts;
    }

    public boolean save(Plot plot) {
        return adminDao.save(plot);
    }

    @Override
    public Plot getPlotByPlotID(int plotId) {
        return adminDao.getPlotByPlotID(plotId);
    }

    @Override
    public City getCityByName(String cityName) {
        return adminDao.getCityByName(cityName);
    }

    @Override
    public District getDistrictByName(String districtName) {
        return adminDao.getDistrictByName(districtName);
    }

    @Override
    public Plot getPlotBySome(String plotName, int districtId) {
        return adminDao.getPlotBySome(plotName, districtId);
    }
}
