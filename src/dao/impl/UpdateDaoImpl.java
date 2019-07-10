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
    @Transactional
    public String updateHouse(HouseInfo houseInfo){

        String plotName =houseInfo.getPlotName();
        //String districtName = houseInfo.getDistrictName();
        //String agentName = houseInfo.getAgentName();
        String address = houseInfo.getAddress();
        double rent = houseInfo.getRent();
        String houseType = houseInfo.getHouseType();
        String floor = houseInfo.getFloor();
        double area = houseInfo.getArea();
        String houseDescription  = houseInfo.getHouseDescription();
        int houseId = houseInfo.getHouseId();
        Session session = sessionFactory.getCurrentSession();
        String hql = "Update House h set h.plotId = (SELECT plotId FROM Plot p where p.plotName = '"+plotName+"')"+"  where h.houseId = "+houseId;
        String hql11 ="Update House h set h.address = '"+ address+"' where h.houseId = "+houseId;
        String hql12 = "update House h set h.rent = "+rent+" where h.houseId = "+houseId;
        String hql13 = "update House h set h.houseType = '"+houseType+"' where h.houseId = "+houseId;
        String hql14 = "update House h set h.floor = '"+floor+"' where h.houseId = "+houseId;
        String hql15 = "update House h set h.area = "+area+" where h.houseId = "+houseId;
        String hql16 = "update House h set h.houseDescription = '"+houseDescription+"' where h.houseId = "+houseId;


        Query query = session.createQuery(hql);
        Query query1 = session.createQuery(hql11);
        Query query2 = session.createQuery(hql12);
        Query query3 = session.createQuery(hql13);
        Query query4 = session.createQuery(hql14);
        Query query5 = session.createQuery(hql15);
        Query query6 = session.createQuery(hql16);



        query.executeUpdate();
        query1.executeUpdate();
        query2.executeUpdate();
        query3.executeUpdate();
        query4.executeUpdate();
        query5.executeUpdate();
        query6.executeUpdate();


        return "success";
    }
}