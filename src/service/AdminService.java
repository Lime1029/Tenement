package service;

import model.*;

import java.util.List;

public interface AdminService {
    public List<User> getAllUsers();
    public void deleteUser(int userId);
    public List<Agent> getAllAgents();
    public void deleteAgent(int agentId);
    public boolean save(Agent agent);
    public List<HouseInfo> getAllHouses();
    public void deleteHouse(int houseId);
    public List<City> getAllCities();
    public boolean modifyCity(int cityId, String cityName);
    public boolean save(City city);
    public void deleteCity(int cityId);
    public List getAllDistricts();
    public boolean modifyDistrict(int cityId, int districtId, String districtName);
    public boolean save(District district);
    public void deleteDistrict(int districtId);
    public List getAllPlots();
    public void deletePlot(int plotId);
    public List getDistrictByCity(int cityId);
    public boolean save(Plot plot);
    public boolean modifyPlot(int plotId, int districtId, int agentId, String plotName);

    public Plot getPlotByPlotID(int plotId);
    public City getCityByName(String cityName);
    public District getDistrictByName(String districtName);
    public Plot getPlotBySome(String plotName, int districtId);

}
