package dao;

import model.House;
import model.PageBean;

import java.util.List;

public interface AgentShowDao {
    public List<House> keywordSearch(String condition);
    public PageBean getHouseInfo(int houseId);
    public List<House> conditionSearch(House housing);
}
