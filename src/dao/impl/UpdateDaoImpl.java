package dao.impl;

import dao.SearchDao;
import dao.UpdateDao;
import model.House;
import model.HouseInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class UpdateDaoImpl implements UpdateDao {
      SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String updateHouse(HouseInfo houseInfo){

        String plotName =houseInfo.getPlotName();
        String districtName = houseInfo.getDistrictName();
        String agentName = houseInfo.getAgentName();
        String address = houseInfo.getAddress();
        double rent = houseInfo.getRent();
        String houseType = houseInfo.getHouseType();
        String floor = houseInfo.getFloor();
        double area = houseInfo.getArea();
        String houseDescription  = houseInfo.getHouseDescription();
        int houseId = houseInfo.getHouseId();
        Session session = sessionFactory.getCurrentSession();
        String hql = "Update house h,plot p ,user u set h.plot_id = p.plot_id,"
        +"h.address = "+address+" ,h.rent = "+ rent +",h.house_type = "+houseType+",h.floor = "+floor+",h.area = "+area+",h.house_description = "+houseDescription+"  where h.house_id = "+houseId+" and p.plot_name ="+plotName;
        ;
        Query query = session.createQuery(hql);

        query.executeUpdate();
        return "success";
    }
}
