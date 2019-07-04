package dao.impl;

import dao.SearchDao;
import model.House;
import model.HouseInfo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class SearchDaoImpl implements SearchDao {
      SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<House> keywordSearch(String condition) {
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

        String hql = "select new model.HouseInfo(p.plotName, d.districtName, a.name, h.address,h.rent, " +
                " h.houseType, h.floor, h.area, h.houseDescription, a.agentId, h.houseId) from House as h, " +
                "Plot as p, District as d, Agent as a where h.plotId = p.plotId and " +
                "p.districtId = d.districtId and p.agentId = a.agentId and h.houseId = " + houseId;
        Query<HouseInfo> query = session.createQuery(hql);

        HouseInfo houseInfo = query.getSingleResult();

        return houseInfo;
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
        String hql = "select h.address, h.rent, h.houseDescription, h.houseId  from House as h, Plot as p, " +
                "District as d where h.plotId = p.plotId and p.districtId = d.districtId and h.state = 1" +
                "and h.rent Between "+housing_leastrent +" AND "+housing_maxrent+
                "and h,house_type  ="+housing_type+
                " and (h.address like '%"+ housing_district+"%' or d.districtName like '%" + housing_district +"%')";
        /**
"select h.address, h.rent, h.house_description, h.house_Id  from House as h, "+
        "Plot as p, District as d where h.plot_Id = p.plot_Id and p.district_id = d.district_id and "+
        "h.plot_Id = "+housing_plot+" and p.district_id = "+housing.ge0 and h.state = 1 and h.rent Between 10.0  AND 1000.0 and h.house_type  = null  and (h.address like '% 天通苑 %' or d.district_Name like '% 天通苑 %');"
     **/   Query<House> query = session.createQuery(hql);
        List<House> houses = query.list();


        return houses;
    }
}
