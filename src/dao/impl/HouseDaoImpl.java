package dao.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.HouseDao;
import model.Agent;
import model.House;
import model.LandlordApplyRelease;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.loader.custom.sql.SQLQueryParser;
import org.hibernate.query.Query;
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

    @Override
    public List<LandlordApplyRelease> getLandlordApply() {
        Agent agent = (Agent)ActionContext.getContext().getSession().get("agent");
        Session session = sessionFactory.getCurrentSession();
        String sql = "select l.apply_id, l.applyer_id, l.applyer_phone, l.applyer_appellation, l.address" +
                ", l.expect_price, l.apply_time, l.plot_id from landlord_apply_release l, plot p, " +
                "Agent a where l.plot_id = p.plot_id and p.agent_id = a.agent_id and " +
                "a.agent_id = '" + agent.getAgentId() + "' order by apply_time DESC;";
        SQLQuery query = session.createSQLQuery(sql).addEntity(LandlordApplyRelease.class);
        List<LandlordApplyRelease> list = query.getResultList();
        return list;
    }

    @Override
    public boolean deleteLandlordApply(int applyId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete from LandlordApplyRelease where applyId =" + applyId;
        Query query = session.createQuery(hql);
        query.executeUpdate();
        return true;
    }
}