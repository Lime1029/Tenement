package service;

import model.*;

import java.util.List;

public interface SearchService {

    public List<House> keywordSearchHouse(String condition);
    public HouseInfo getHouseInfo(int houseId);
    public List<User> keywordSearchUser(String condition);
    public List<Agent> keywordSearchAgent(String condition);
    public List<HouseInfo> keywordSearchAdminHouse(String condition);
    public List<City> searchCity(String condition);
    public List searchDistrict(String condition);
    public List searchPlot(String condition);


    public List<House> conditionSearch(House housing);
}
