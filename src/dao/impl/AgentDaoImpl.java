package dao.impl;

import model.Agent;
import dao.AgentDao;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional//事务注解
@Repository
public class AgentDaoImpl implements AgentDao {
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Agent> getAgentByAgentName(String name){
        Session session =sessionFactory.getCurrentSession();
        SQLQuery query= session.createSQLQuery("select * from agent where name = '"+name+"'");
        query.addEntity(Agent.class);
        List<Agent> agents = query.list();
        return agents;
    }
}