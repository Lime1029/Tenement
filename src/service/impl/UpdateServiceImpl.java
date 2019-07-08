package service.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.SearchDao;
import dao.UpdateDao;
import model.House;
import model.HouseInfo;
import service.SearchService;
import service.UpdateService;

import java.util.List;

public class UpdateServiceImpl implements UpdateService {
    private UpdateDao updateDao;

    public UpdateDao getUpdateDao() {
        return updateDao;
    }

    public void setUpdateDao(UpdateDao updateDao) {
        this.updateDao = updateDao;
    }

    @Override
    public String updateHouse(HouseInfo houseInfo){
        String resultMess = updateDao.updateHouse(houseInfo);
        return resultMess;
    }
}
