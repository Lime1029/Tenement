package dao.impl;

import dao.ChatDao;
import model.User;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import model.Chat;

import java.util.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional//事务注解
@Repository
public class ChatDaoImpl implements ChatDao {
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Chat> getChatByUserIDAndAgentID(int userID,int agentID){
        Session session =sessionFactory.getCurrentSession();
        SQLQuery query= session.createSQLQuery("select * from chat where user_id = "+userID+" and agent_id= "+agentID+" order by send_time");
        query.addEntity(Chat.class);
        List<Chat> chats = query.list();
        return chats;
    }
    @Override
    public List<List<Chat>> getChatByAgentID(int agentID){
        Session session =sessionFactory.getCurrentSession();
        SQLQuery query= session.createSQLQuery("select * from chat where agent_id= "+agentID+" order by send_time");
        query.addEntity(Chat.class);
        List<Chat> chats = query.list();
        List<List<Chat>> user_chats = new ArrayList<List<Chat>>();
        Map<String,List<Chat>>userID_Chats = new HashMap<String,List<Chat>>();
        int numOfKey = 0;
        for (int i=0;i<chats.size();i++){
            String userID = String.valueOf(chats.get(i).getUserId());
            if(!userID_Chats.containsKey(userID)){
                List<Chat> per_user_chats = new ArrayList<>();
                per_user_chats.add(chats.get(i));
                userID_Chats.put(userID,per_user_chats);
            }
            else{
                userID_Chats.get(userID).add(chats.get(i));
            }
        }for (String key : userID_Chats.keySet()) {
            user_chats.add(userID_Chats.get(key));
        }
        Collections.reverse(user_chats);
        return user_chats;
    }
    @Override
    public String save(Chat chat) {
        Session session= sessionFactory.getCurrentSession();
        try{
            session.save(chat);
        }catch(HibernateException e){
            return "error";
        }
        finally {
            //session.close();//关闭连接
        }
        return "success";
    }
    public List findByProperty(String[] PropertyName,int[] id){
        Session session =sessionFactory.getCurrentSession();
        List<Chat> chats = null;
        Criteria cr = null;
        for(int i=0; i<PropertyName.length; i++){
            cr = session.createCriteria(Chat.class);
            cr.add(Restrictions.eq(PropertyName[i],id[i]));
        }
            chats=cr.list();
            return chats;
    }
}
