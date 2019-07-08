package service.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.SearchDao;
import model.*;
import service.SearchService;

import java.util.List;

public class SearchServiceImpl implements SearchService {
    private SearchDao searchDao;

    public SearchDao getSearchDao() {
        return searchDao;
    }

    public void setSearchDao(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    @Override
    public List<House> keywordSearchHouse(String condition) {
        List<House> houses = searchDao.keywordSearchHouse(condition);

        return houses;

    }

    @Override
    public HouseInfo getHouseInfo(int houseId) {
        HouseInfo houseInfo = searchDao.getHouseInfo(houseId);
        ActionContext.getContext().getSession().put("houseInfo", houseInfo);

        return houseInfo;
    }

    @Override
    public List<User> keywordSearchUser(String condition) {
        return searchDao.keywordSearchUser(condition);
    }

    @Override
    public List<Agent> keywordSearchAgent(String condition) {
        List<Agent> agents = searchDao.keywordSearchAgent(condition);
        ActionContext.getContext().getSession().put("agents", agents);
        return agents;
    }

    @Override
    public List<HouseInfo> keywordSearchAdminHouse(String condition) {
        List<HouseInfo> houseInfoList = searchDao.keywordSearchAdminHouse(condition);
        ActionContext.getContext().getSession().put("adminHouses", houseInfoList);

        return houseInfoList;
    }

    @Override
    public List<City> searchCity(String condition) {
        List<City> cities = searchDao.searchCity(condition);
        ActionContext.getContext().getSession().put("cities", cities);

        return cities;
    }

    @Override
    public List searchDistrict(String condition) {
        List districts = searchDao.searchDistrict(condition);
        ActionContext.getContext().getSession().put("districts", districts);

        return districts;
    }

    @Override
    public List searchPlot(String condition) {
        List plots = searchDao.searchPlot(condition);
        ActionContext.getContext().getSession().put("plots", plots);

        return plots;
    }


    @Override
    public List<House> conditionSearch(House housing) {

        List<House> houses = searchDao.conditionSearch(housing);

        return houses;

    }
}
