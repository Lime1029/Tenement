package service.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.SearchDao;
import model.House;
import model.HouseInfo;
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
    public List<House> keywordSearch(String condition) {
        List<House> houses = searchDao.keywordSearch(condition);

        return houses;

    }

    @Override
    public HouseInfo getHouseInfo(int houseId) {
        HouseInfo houseInfo = searchDao.getHouseInfo(houseId);
        ActionContext.getContext().getSession().put("houseInfo", houseInfo);

        return houseInfo;
    }
}
