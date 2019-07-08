package dao.impl;

import dao.HouseDao;
import model.House;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional//事务注解
@Repository
public class HouseDaoImpl implements HouseDao{
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public House findHouseByHouseID(int houseID){
        Session session =sessionFactory.getCurrentSession();
        SQLQuery query= session.createSQLQuery("select * from house where house_id = "+houseID);
        query.addEntity(House.class);
        List<House> houses = query.list();
        if (houses == null)
            return null;
        return houses.get(0);
    }
}