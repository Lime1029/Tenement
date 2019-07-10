package dao;

import model.*;

import java.util.List;

public interface AdminDao {
    public List<User> getAllUsers();
    public List<Agent> getAllAgents();
    public List<HouseInfo> getAllHouses();
    public List getAllPlots();
    public List getAllDistricts();
    public List<City> getAllCities();
    public List getDistrictByCity(int cityId);

    public void deleteUser(int userId);
    public void deleteAgent(int agentId);
    public void deleteHouse(int houseId);
    public void deleteCity(int cityId);
    public void deletePlot(int plotId);
    public void deleteDistrict(int districtId);

    public boolean save(Agent agent);
    public boolean save(City city);
    public boolean save(District district);
    public boolean save(Plot plot);

    public boolean modifyCity(int cityId, String cityName);
    public boolean modifyDistrict(int cityId, int districtId, String districtName);
    public boolean modifyPlot(int plotId, int districtId, int agentId, String plotName);

    public Plot getPlotByPlotID(int plotId);
    public City getCityByName(String cityName);
    public District getDistrictByName(String districtName);
    public Plot getPlotBySome(String plotName, int districtId);
}
