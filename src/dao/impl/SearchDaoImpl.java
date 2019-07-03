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
    private SessionFactory sessionFactory;

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
}
