package service.impl;

import model.House;
import org.springframework.stereotype.Service;
import dao.HouseDao;
import service.HouseService;
public class HouseServiceImpl implements HouseService{
    private HouseDao houseDao;
    public HouseDao getHouseDao(){return houseDao;}
    public void setHouseDao(HouseDao houseDao){this.houseDao = houseDao;}
    @Override
    public House findHouseByHouseID(int houseID){
        House house = houseDao.findHouseByHouseID(houseID);
        return house;
    }
}
