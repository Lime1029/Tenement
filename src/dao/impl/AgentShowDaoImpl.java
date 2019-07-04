package dao.impl;

import dao.AgentShowDao;
import dao.AdminDao;
import model.*;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
         */
        public List queryForPage(final String hql,final int offset,final int length){
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
        public int getAllRowCount(String hql){
            return getSessionFactory().getCurrentSession().createQuery(hql).list().size();
            //return getHibernateTemplate().find(hql).size();
        }
    }

