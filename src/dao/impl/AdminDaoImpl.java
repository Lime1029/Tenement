package dao.impl;

import dao.AdminDao;
import model.*;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional//声明式事务管理，使用 HibernateTemplate 实现 CRUD 操作，一定要加上事务管理，否则将报错
public class AdminDaoImpl implements AdminDao {
    private SessionFactory sessionFactory;
    //private HibernateTemplate hibernateTemplate;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /*public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }*/

    @Override
    public List<User> getAllUsers() {
        //hql语句对象是类
        String hql = " from User";
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery(hql);
        List<User> users = query.list();


        return users;
    }

    @Override
    public List<Agent> getAllAgents() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Agent";
        Query query = session.createQuery(hql, Agent.class);
        List<Agent> agents = query.list();

        return agents;
    }

    @Override
    public List<HouseInfo> getAllHouses() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select new model.HouseInfo(p.plotName, d.districtName, a.name, h.address, h.rent, " +
                " h.houseType, h.floor, h.area, a.agentId, h.houseId, h.releaseTime, a.telephone, h.state, u.name, u.telephone) " +
                "from House as h, User u, " +
                "Plot as p, District as d, Agent as a where h.plotId = p.plotId and " +
                "p.districtId = d.districtId and p.agentId = a.agentId and h.landlordId = u.userId";
        Query<HouseInfo> query = session.createQuery(hql);
        List<HouseInfo> houses = query.list();

        return houses;
    }



    @Override
    public List getAllPlots() {

        Session session = sessionFactory.getCurrentSession();
        String hql = "select p.plotId, p.plotName, c.id, c.name, d.districtId, d.districtName, a.agentId, a.name " +
                " from Plot p, District d, City c, Agent a " +
                " where p.agentId = a.agentId and p.districtId = d.districtId and c.id = d.cityId";
        Query query = session.createQuery(hql);
        List plots = query.list();

        return plots;
    }

    @Override
    public List getAllDistricts() {

        Session session = sessionFactory.getCurrentSession();
        String hql = "select d.districtId, d.districtName, c.id,  c.name from District d, City c " +
                "where d.cityId = c.id";
        Query query = session.createQuery(hql);
        List districts = query.list();

        return districts;

    }

    @Override
    public List<City> getAllCities() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from City";
        Query<City> query = session.createQuery(hql);
        List<City> cities = query.getResultList();

        return cities;

    }

    @Override
    public void deleteUser(int userId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete from User where userId = " + userId;
        Query query = session.createQuery(hql);
        query.executeUpdate(); //返回受影响的行数（更新计数）

    }

    @Override
    public void deleteAgent(int agentId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete from Agent where agentId = " + agentId;
        Query query = session.createQuery(hql);
        query.executeUpdate();
    }

    @Override
    public void deleteHouse(int houseId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete from House where houseId = " + houseId;
        Query query = session.createQuery(hql);
        query.executeUpdate();
    }

    @Override
    public boolean save(Agent agent) {
        Session session= sessionFactory.getCurrentSession();
        try{
            session.save(agent);
        }catch(HibernateException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean save(City city) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(city);
        }catch (HibernateException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean save(District district) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(district);
        }catch (HibernateException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean modifyCity(int cityId, String cityName) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "update City c set c.name = '" + cityName + "' where c.id = " + cityId;
        Query query = session.createQuery(hql);

        query.executeUpdate();

        return true;
    }

    @Override
    public void deleteCity(int cityId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete from City where id = " + cityId;
        Query query = session.createQuery(hql);
        query.executeUpdate();
    }

    @Override
    public boolean modifyDistrict(int cityId, int districtId, String districtName) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "update District d set cityId = " + cityId + ", districtName = '" +
                districtName + "' where districtId = " + districtId;
        Query query = session.createQuery(hql);

        query.executeUpdate();

        return true;
    }

    @Override
    public void deleteDistrict(int districtId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete from District where districtId = " + districtId;
        Query query = session.createQuery(hql);
        query.executeUpdate();
    }

    @Override
    public void deletePlot(int plotId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete from Plot where plotId = " + plotId;
        Query query = session.createQuery(hql);
        query.executeUpdate();
    }

    @Override
    public List getDistrictByCity(int cityId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select d.districtId, d.districtName from District d, City c " +
                "where d.cityId = c.id and c.id = " + cityId;
        Query query = session.createQuery(hql);
        List districts = query.list();

        return districts;
    }

    @Override
    public boolean save(Plot plot) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(plot);
        }catch (HibernateException e) {
            return false;
        }
        return true;
    }

    @Override
    public Plot getPlotByPlotID(int plotId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Plot where plotId =" + plotId;
        Query<Plot> query = session.createQuery(hql);
        Plot plot = query.uniqueResult();
        return plot;
    }
}
