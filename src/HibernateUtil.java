package org.hibernate.entity;

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
    // 创建线程局部变量threadLocal，用来保存Hibernate的Session
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    // 使用静态代码块初始化Hibernate
    static {
        try {
            // 读取配置文件方式1，hibernate4.3之前
//            Configuration cfg = new Configuration().configure();
//            // 创建服务注册对象
//            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                    .applySettings(cfg.getProperties()).build();
//            // 创建会话工厂对象SessionFactory
//            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
//
            // 读取配置文件方式2，hibernate4.3之后
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();
            //创建会话工厂对象
            sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    // 获得SessionFactory的实例
    public static SessionFactory getsSessionFactory() {
        return sessionFactory;
    }

    // 获得ThreadLocal对象管理的Session
    public static Session getsSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            // 通过SessionFactory对象创建Session对象
            session = (sessionFactory != null) ? sessionFactory.openSession() : null;
            // 将Session对象保存到线程局部变量threadLocal中
            threadLocal.set(session);
        }
        return session;
    }

    // 关闭Session实例
    public static void closeSession() {
        // 从线程局部变量threadLocal中获取之前存入的Session实例
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }

    // 重建SessionFactory
    public static void rebuildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("/hibernate.cfg.xml");
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    // 关闭缓存和连接池
    public static void shutdown() {
        getsSessionFactory().close();
    }
}