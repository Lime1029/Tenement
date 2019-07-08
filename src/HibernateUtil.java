//package org.hibernate.entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    // �����ֲ߳̾�����threadLocal����������Hibernate��Session
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    // ʹ�þ�̬������ʼ��Hibernate
    static {
        try {
            // ��ȡ�����ļ���ʽ1��hibernate4.3֮ǰ
//            Configuration cfg = new Configuration().configure();
//            // ��������ע�����
//            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                    .applySettings(cfg.getProperties()).build();
//            // �����Ự��������SessionFactory
//            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
//
            // ��ȡ�����ļ���ʽ2��hibernate4.3֮��
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();
            //�����Ự��������
            sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    // ���SessionFactory��ʵ��
    public static SessionFactory getsSessionFactory() {
        return sessionFactory;
    }

    // ���ThreadLocal��������Session
    public static Session getsSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            // ͨ��SessionFactory���󴴽�Session����
            session = (sessionFactory != null) ? sessionFactory.openSession() : null;
            // ��Session���󱣴浽�ֲ߳̾�����threadLocal��
            threadLocal.set(session);
        }
        return session;
    }

    // �ر�Sessionʵ��
    public static void closeSession() {
        // ���ֲ߳̾�����threadLocal�л�ȡ֮ǰ�����Sessionʵ��
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }

    // �ؽ�SessionFactory
    public static void rebuildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("/hibernate.cfg.xml");
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    // �رջ�������ӳ�
    public static void shutdown() {
        getsSessionFactory().close();
    }
}