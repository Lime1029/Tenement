package dao.impl;

import dao.AdminDao;
import model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional//声明式事务管理，使用 HibernateTemplate 实现 CRUD 操作，一定要加上事务管理，否则将报错
public class AdminDaoImpl implements AdminDao {
    private SessionFactory sessionFactory;
    private HibernateTemplate hibernateTemplate;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<User> getAllUsers() {
        //hql语句对象是类
        String hql = "select userId, telephone, password from User";
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery(hql);
        List<User> users = query.list();


        return users;
    }

    @Override
    public List<Agent> getAllAgents() {
        return null;
    }

    @Override
    public List<House> getAllHouses() {

        return null;
    }

    @Override
    public List<Plot> getAllPlots() {

        return null;
    }

    @Override
    public List<District> getAllDistricts() {

        return null;
    }

    @Override
    public List<City> getAllCities() {

        return null;
    }
}
