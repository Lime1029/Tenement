package dao.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.AgentShowDao;
import dao.AdminDao;
import model.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public class AgentShowDaoImpl extends HibernateDaoSupport implements AgentShowDao {
    //省略了其他的代码

    /** *//**
     * 分页查询
     * @param hql 查询的条件
     * @param offset 开始记录
     * @param length 一次查询几条记录
     * @return
     **/

    @Transactional
    public List queryForPage(final int offset,final int length){
        Agent agent = (Agent)ActionContext.getContext().getSession().get("agent");
        final String hql = "Select p.plotName, d.districtName, a.name, h.address,h.rent, " +
                " h.houseType, h.floor, h.area, h.houseDescription, a.name, h.houseId FROM House as h, " +
                "Plot as p, District as d, Agent as a where h.plotId = p.plotId and " +
                "p.districtId = d.districtId and p.agentId = a.agentId and a.agentId = " +  agent.getAgentId();

        List list = (List)getHibernateTemplate().execute(new HibernateCallback(){
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);

                query.setFirstResult(offset);
                query.setMaxResults(length);
                List list = query.list();
                return list;
            }
        });
        return list;
    }

    @Transactional
    public List queryForContract(final int offset,final int length){
        Agent agent = (Agent)ActionContext.getContext().getSession().get("agent");
        final String hql = "Select c.contractId,c.stime,c.etime,a.name,u2.name,u1.name,c.houseId FROM Contract as c, " +
                "User as u1,User as u2, Agent as a, House as h, Plot as p where c.tenantId = u1.id and " +
                "c.tenantId = u2.id and p.agentId = a.agentId and p.plotId = h.plotId and h.houseId = c.houseId" +
                " and a.agentId = " + agent.getAgentId() ;

        List list = (List)getHibernateTemplate().execute(new HibernateCallback(){
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);

                query.setFirstResult(offset);
                query.setMaxResults(length);
                List list = query.list();
                return list;
            }
        });
        return list;
    }
    /** *//**
     * 查询所有记录数
     * @return 总记录数
     */
    @Transactional
    public int getAllRowCount(){
        Agent agent = (Agent)ActionContext.getContext().getSession().get("agent");
        final String hql = "Select new model.HouseInfo(p.plotName, d.districtName, a.name, h.address,h.rent, " +
                " h.houseType, h.floor, h.area, h.houseDescription, a.agentId, h.houseId) from House as h, " +
                "Plot as p, District as d, Agent as a where h.plotId = p.plotId and " +
                "p.districtId = d.districtId and p.agentId = a.agentId and a.agentId = " + agent.getAgentId();
        int a =getSessionFactory().getCurrentSession().createQuery(hql).list().size();
        return getSessionFactory().getCurrentSession().createQuery(hql).list().size();
        //return getHibernateTemplate().find(hql).size();
    }

    @Transactional
    public int getAllContractCount(){
        Agent agent = (Agent)ActionContext.getContext().getSession().get("agent");
        final String hql = "Select c.contractId,c.stime,c.etime,a.name,u2.name,u1.name,c.houseId FROM Contract as c, " +
                "User as u1,User as u2, Agent as a, House as h, Plot as p where c.tenantId = u1.id and " +
                "c.tenantId = u2.id and  p.agentId = a.agentId and p.plotId = h.plotId and c.houseId = h.houseId" +
                " and a.agentId = " + agent.getAgentId();
        int a =getSessionFactory().getCurrentSession().createQuery(hql).list().size();
        return getSessionFactory().getCurrentSession().createQuery(hql).list().size();
        //return getHibernateTemplate().find(hql).size();
    }

    @Override
    @Transactional
    public int endContract(int contractID) {
        Session session = getSessionFactory().getCurrentSession();
        String hql = "update House as h , HouseApplyer as ha , Contract as c set h.state = 0 and ha.isSellOn = 1 where c.house_id = h.house_id and c.house_id = ha.house_id and ha.isSellOn = 0 and c.contract_id = "+contractID;
        Query query = session.createQuery(hql);
        query.executeUpdate();
        return 1;
    }
}