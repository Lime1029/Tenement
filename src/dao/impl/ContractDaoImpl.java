package dao.impl;
/**
 package org.hibernate.dao;
 import java.util.ArrayList;
 import java.util.List;
 import org.hibernate.Session;
 import org.hibernate.Transaction;
 import org.hibernate.entity.HibernateUtil;
 /**
 public class ContractDAOImpl  {
 // ����û�����Ҫ�������
 @Override
 public void save(User user) {
 // ����Sessionʵ��
 Session session = HibernateUtil.getsSession();
 // ����Transactionʵ��
 Transaction tx = session.beginTransaction();
 try {
 // ʹ��Session��save�������־û����󱣴浽���ݿ�
 session.save(user);
 // �ύ����
 tx.commit();
 } catch (Exception e) {
 e.printStackTrace();
 // �����쳣���ع�����
 tx.rollback();
 } finally {
 // �ر�Session����
 HibernateUtil.closeSession();
 }
 }
 // ����id�����û� ,���Բ���Ҫ������� Get��ʽ
 @Override
 public User findByIdGet(int id) {
 User user = null;
 Session session = HibernateUtil.getsSession();
 // ʹ��session��get������ȡָ��id���û�
 user = (User) session.get(User.class, id);
 if (user == null || "".equals(user)) {
 System.out.println("��ѯidΪ��" + id + "�޽��....");
 }
 session.close();
 return user;
 }
 // ����id�����û� ,���Բ���Ҫ������� Load��ʽ
 @Override
 public User findByIdLoad(int id) {
 User user = null;
 Session session = HibernateUtil.getsSession();
 // ʹ��session�ķ�����ȡָ��id���û�
 user = (User) session.load(User.class, id);
 if (user == null || "".equals(user)) {
 System.out.println("��ѯidΪ��" + id + "�޽��....");
 }
 session.close();
 return user;
 }
 // ����HQl����ѯ
 @Override
 public List<User> findByHQL(String hql) {
 List<User> list = new ArrayList<>();
 Session session = HibernateUtil.getsSession();
 list = session.createQuery(hql).list();
 session.close();
 return list;
 }
 // ɾ���û� ,��Ҫ�������
 @Override
 public void delete(User user) {
 Session session = HibernateUtil.getsSession();
 Transaction tx = session.beginTransaction();
 try {
 session.delete(user);
 tx.commit();
 } catch (Exception e) {
 e.printStackTrace();
 tx.rollback();
 } finally {
 HibernateUtil.closeSession();
 }
 }
 // �޸��û�
 @Override
 public void update(User user) {
 Session session = HibernateUtil.getsSession();
 Transaction tx = session.beginTransaction();
 try {
 session.update(user);
 tx.commit();
 } catch (Exception e) {
 e.printStackTrace();
 tx.rollback();
 } finally {
 HibernateUtil.closeSession();
 }
 }
 }
 **/