package service;

import model.House;
import model.HouseInfo;

import java.util.List;

public interface SearchService {

    public List<House> keywordSearch(String condition);
    public HouseInfo getHouseInfo(int houseId);
}
