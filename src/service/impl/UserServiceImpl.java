package service.impl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.*;
import org.springframework.stereotype.Service;
import service.UserService;
import dao.UserDao;

import java.util.List;

@Service("UserService")// so that spring context can autodetect it and we can get its instance from the context
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao(){
        return userDao;
    }
    public void setUserDao(UserDao userDAO) {
        this.userDao = userDAO;
    }

    @Override
    public User getUserByTel(String telephone) {
        User user = userDao.getUserByTel(telephone);
        if (user != null) {
            return user;
        }
        else return null;
    }
    @Override
    public Agent getAgentByTel(String telephone) {
        Agent agent = userDao.getAgentByTel(telephone);
        if (agent != null) {
            return agent;
        }
        else return null;
    }
    @Override
    public Administrator getAdminByTel(String telephone) {
        Administrator administrator = userDao.getAdminByTel(telephone);
        if (administrator != null) {
            return administrator;
        }
        else return null;
    }
    public User getUserByLoginName(String username){
        User user= userDao.findByLoginName(username);
        if(user!=null){
            return user;
        }
        else
            return null;
    }
    @Override
    public boolean save(User user){
        return  userDao.save(user);
    }
    @Override
    public boolean savehouse(LandlordApplyRelease landlordApplyRelease){
            return  userDao.savehouse(landlordApplyRelease);
    }
    @Override
    public boolean messageSubmit(DiscussionSection discussionSection){return userDao.messageSubmit(discussionSection);}
    @Override
    public boolean modifyUser(User newuser) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean updatePass(Long id, String newPassword) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public List messageSave()
    {
        List list = userDao.getNotice();
        ActionContext.getContext().getSession().put("message",list);
        return  list;
    }

    @Override
    public void plotSave() {
        List list = userDao.getPlot();
        ActionContext.getContext().getSession().put("plot",list);

    }
    @Override
    public void plotGet() {
        List list = userDao.plotGet();
        ActionContext.getContext().getSession().put("userplot",list);

    }

    public void houseSave(String phone)
    {
        Integer user_id = userDao.getHouse_userid(phone);

        ActionContext.getContext().getSession().put("house_userid",user_id);

        Integer landlord_id = userDao.getHouse_userid(phone);


    }
    @Override
    public boolean confirmHouse(House house,String phone)
    {
        return  userDao.confirmHouse(house,phone);



    }




}
