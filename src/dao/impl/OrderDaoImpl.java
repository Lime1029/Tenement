package dao.impl;

import dao.OrderDao;
import model.Order;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.loader.custom.sql.SQLCustomQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//对数据库直接进行操作的实现类，最底层（层数：1）
@Transactional//事务注解
@Repository
public class OrderDaoImpl implements OrderDao {
    //OrderDaoImpl是OrderDao接口的实现类

    //初始化SessionFactory，每个Dao的Impl里开头必须有的。
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean saveOrder(Order order,String applyerTelephone,String applyerName) {
        //查询applyerTelephone对应的userId
        int applyerId=getApplyerIdByTel(applyerTelephone);
        //附加：把jsp中写入的applyer姓名写入对应user_id,对应的user_name中。
        insertUserName(applyerName,applyerId);
        //new一个新的order对象
        Order newOrder=new Order();
        newOrder.setHouseId(order.getHouseId());
        newOrder.setAgentId(order.getAgentId());
        newOrder.setApplyerId(applyerId);
        newOrder.setOrderStime(order.getOrderStime());
        newOrder.setOrderEtime(order.getOrderEtime());
        newOrder.setOrderRent(order.getOrderRent());
        newOrder.setLandlordId(order.getLandlordId());

        //读取order中的属性值，并重新封装到一个新的order里，
        //保存新的order到数据库
        Session session= sessionFactory.getCurrentSession();
        try{
            String sql="insert into `order`(order_stime, landlord_id, order_rent,agent_id, order_etime, " +
                    "applyer_id, house_id) values(?, ?, ?, ?, ?, ?, ?);";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1, newOrder.getOrderStime())
            .setParameter(2, newOrder.getLandlordId())
            .setParameter(3, newOrder.getOrderRent())
            .setParameter(4, newOrder.getAgentId())
            .setParameter(5, newOrder.getOrderEtime())
                    .setParameter(6, newOrder.getApplyerId())
            .setParameter(7, newOrder.getHouseId());
            query.executeUpdate();
        }catch(HibernateException e){
            return false;
        }
        finally {
            //session.close();
            // session会自己关闭，所以这里不需要关闭连接
        }
        return true;
    }

    public int getApplyerIdByTel(String applyerTelephone){
        //根据applyerTelephone参数，查询对应的user表中的user.id
        //并返回user.id
        String sql="select * FROM tenement.user where telephone='"+applyerTelephone+"';";
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query=session.createSQLQuery(sql).addEntity(User.class);
        User user = (User)query.uniqueResult();
        int userId=user.getUserId();
        return userId;
    }

    public void insertUserName(String applyerName,int userId){
        //根据applyerName参数，写入对应user表中的user.name,无返回值
        Session session=sessionFactory.getCurrentSession();
        String sql="UPDATE user SET name='"+applyerName+"'where user_id = '" + userId +"';";
        SQLQuery query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public List<Order> getMyOrder(int agentId){

        //使用sql查询语句
        String sql="SELECT * FROM `order` where agent_id='" + agentId +"';";
        Session session = sessionFactory.getCurrentSession();
        //将结果存入orders（列表）并返回orders列表
        SQLQuery<Order> query=session.createSQLQuery(sql);
        List<Order> orders=query.list();
        return orders;
    }


}
