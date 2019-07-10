package dao;

import model.House;
public interface HouseDao {
    public House findHouseByHouseID(int houseID);
}