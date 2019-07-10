package dao;

import model.House;
import model.LandlordApplyRelease;

import java.util.List;

public interface HouseDao {
    public House findHouseByHouseID(int houseID);

    public List<LandlordApplyRelease> getLandlordApply();

    public boolean deleteLandlordApply(int applyId);


}