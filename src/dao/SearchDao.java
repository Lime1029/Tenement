package dao;

import model.House;
import model.HouseInfo;

import java.util.List;

public interface SearchDao {
    public List<House> keywordSearch(String condition);
    public HouseInfo getHouseInfo(int houseId);
}
