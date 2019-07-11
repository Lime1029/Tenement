package dao.impl;

import dao.SearchDao;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class SearchDaoImpl implements SearchDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<House> keywordSearchHouse(String condition) {
        Session session = sessionFactory.getCurrentSession();

        //在这里多表查询时，记得属性要写清是哪个表的属性，否则判断不出就会出现空指针异常
        String hql = "select h.address, h.rent, h.houseDescription, h.houseId from House as h, Plot as p, " +
                "District as d where h.plotId = p.plotId and p.districtId = d.districtId and h.state = 1" +
                " and (p.plotName like '%"+ condition+"%' or d.districtName like '%" + condition +"%')";
        Query<House> query = session.createQuery(hql);
        List<House> houses = query.list();


        return houses;
    }

    @Override
    public HouseInfo getHouseInfo(int houseId) {
        Session session = sessionFactory.getCurrentSession();

        //不知为何，releaseTime查出来的变成了java.util.Date类型而不是Timestamp
        String hql = "select new model.HouseInfo(p.plotName, d.districtName, a.name, h.address,h.rent, " +
                " h.houseType, h.floor, h.area, h.houseDescription, a.agentId, h.houseId, h.releaseTime) from House as h, " +
                "Plot as p, District as d, Agent as a where h.plotId = p.plotId and " +
                "p.districtId = d.districtId and p.agentId = a.agentId and h.houseId = " + houseId;
        Query<HouseInfo> query = session.createQuery(hql);

        HouseInfo houseInfo = query.uniqueResult();//getSingleResult()如果查不到就会出异常，不会返回null

        return houseInfo;
    }

    @Override
    public List<User> keywordSearchUser(String condition) {
        Session session = sessionFactory.getCurrentSession();
        //这里有对int类型的属性的模糊查询，需要用到cast(属性 as string)
        String hql = "from User where cast(userId as string ) like '%" + condition + "%' or telephone like '%" +
                condition + "%' or name like '%" + condition + "%'";
        Query<User> query = session.createQuery(hql);

        List<User> users = query.list();

        return users;
    }

    @Override
    public List<Agent> keywordSearchAgent(String condition) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "from Agent where cast(agentId as string) like '%" + condition + "%' or " +
                "telephone like '%" + condition + "%' or name like '%" + condition + "%'";
        Query<Agent> query = session.createQuery(hql);

        return query.list();
    }

    @Override
    public List<HouseInfo> keywordSearchAdminHouse(String condition) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "select new model.HouseInfo(p.plotName, d.districtName, a.name, h.address, h.rent, " +
                "h.houseType, h.floor, h.area, a.agentId, h.houseId, h.releaseTime, a.telephone, h.state, u.name, u.telephone) " +
                "from House as h, User u, Plot as p, District as d, Agent as a where h.plotId = p.plotId and " +
                "p.districtId = d.districtId and p.agentId = a.agentId and h.landlordId = u.userId " +
                "and (u.telephone like '%" + condition + "%' or u.name like '%" + condition + "%' or " +
                "h.address like '%" + condition + "%' or p.plotName like '%" + condition + "%' or a.name like '%" + condition + "')";
        Query<HouseInfo> query = session.createQuery(hql);
        List<HouseInfo> houseInfoList = query.list();

        return houseInfoList;
    }

    @Override
    public List<City> searchCity(String condition) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "from City c where c.name like '%" + condition + "%'";
        Query<City> query = session.createQuery(hql);
        List<City> cities = query.list();

        return cities;
    }

    @Override
    public List searchDistrict(String condition) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select d.districtId, d.districtName, c.name from District d, City c " +
                " where d.cityId = c.id and (d.districtName like '%" + condition + "%' or " +
                " c.name like '%" + condition + "%')";
        Query query = session.createQuery(hql);
        List districts = query.list();

        return districts;

    }

    @Override
    public List searchPlot(String condition) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select p.plotId, p.plotName, c.name, d.districtName, a.name " +
                " from Plot p, District d, City c, Agent a " +
                " where p.agentId = a.agentId and p.districtId = d.districtId and c.id = d.cityId " +
                " and (a.name like '%" + condition + "%' or c.name like '%" + condition + "%' or " +
                " p.plotName like '%" + condition + "%' or d.districtName like '%" + condition + "%')";
        Query query = session.createQuery(hql);
        List plots = query.list();

        return plots;
    }


    @Override
    public List<House> conditionSearch(House housing){
        String housing_district = housing.getAddress();
        Double housing_maxrent = housing.getRent();
        int housing_plot  =housing.getPlotId();
        //Integer housing_state = housing.getState();
        //String housing_RentType = housing.getHouseType();
        String housing_type = housing.getHouseType();
        Double housing_leastrent = housing.getArea();
        //String housing_description = housing.getHouseDescription();
        Session session = sessionFactory.getCurrentSession();
        //在这里多表查询时，记得属性要写清是哪个表的属性，否则判断不出就会出现空指针异常
        boolean district = (housing_district!=null);
        boolean plot = (housing_plot!=0);
        boolean type = (housing_type!=null);


        String hql1 = "select h.address, h.rent, h.houseDescription, h.houseId  from House as h, " +
                "Plot as p,District as d where h.state = 1 and h.rent Between "+ housing_leastrent+" AND "+housing_maxrent;
        if(plot){
            hql1 = hql1+" and h.plotId = "+housing_plot;
        }
        if(district){
            hql1 = hql1+" and h.plotId = p.plotId and p.districtId = d.districtId and d.districtName like '%" + housing_district + "%'";
        }
        if(type){
            hql1 = hql1+" and h.houseType like '%" + housing_type + "%'";
        }

        //String hql = "select h.address, h.rent, h.houseDescription, h.houseId  from House as h, "+
        //      "Plot as p, District as d where h.plotId = p.plotId and p.districtId = d.districtId and "+
        //    "h.plotId = "+housing_plot+" and p.districtId = ' "+housing_district+ " ' and  h.state = 1 and h.rent Between "+ housing_leastrent+"  AND "+housing_maxrent
        //  +" and h.houseType  = ' "+ housing_type +" ' ";
        //    +" and (h.address like '% "+ condition+"%' or d.districtName like '%" + condition +"%')";
        //Query<House> query = session.createQuery(hql);
        Query<House> query = session.createQuery(hql1);
        List<House> houses = query.list();


        return houses;
    }
}
