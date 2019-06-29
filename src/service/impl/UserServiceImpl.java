package service.impl;

import model.Administrator;
import model.Agent;
import org.springframework.stereotype.Service;
import service.UserService;
import model.User;
import dao.UserDao;

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
    public boolean modifyUser(User newuser) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean updatePass(Long id, String newPassword) {
        // TODO Auto-generated method stub
        return false;
    }
}
