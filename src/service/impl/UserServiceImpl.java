package service.impl;

import com.opensymphony.xwork2.ActionContext;
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
    @Override
    public List<HouseInfo> searchMyHouse(int userId) {
        List<HouseInfo> houseInfoList = userDao.searchMyHouse(userId);
        ActionContext.getContext().getSession().put("myHouses", houseInfoList);

        searchMyRentalHouse(userId);

        return houseInfoList;
    }

    @Override
    public List<HouseInfo> searchMyRentalHouse(int userId) {
        List<HouseInfo> houseInfoList = userDao.searchMyRentalHouse(userId);
        ActionContext.getContext().getSession().put("myRental", houseInfoList);

        return houseInfoList;
    }

    @Override
    public List<ContractInfo> getMyContract(int houseId) {
        List<ContractInfo> contractInfoList = userDao.getContract(houseId);
        ActionContext.getContext().getSession().put("myContract", contractInfoList);

        return contractInfoList;
    }

    @Override
    public List<ContractInfo> getContractAsTenant(int houseId, int userId) {
        List<ContractInfo> contractInfoList = userDao.getContractAsTenant(houseId, userId);
        ActionContext.getContext().getSession().put("myContract", contractInfoList);

        return contractInfoList;
    }

    @Override
    public List<OrderDisplay> getMyOutstandingOrders(int userId) {
        List<OrderDisplay> orders = userDao.getMyOutstandingOrders(userId);
        ActionContext.getContext().getSession().put("myOutstandingOrders", orders);
        List<OrderDisplay> orders1 = userDao.getMyPrepaidOrders(userId);
        ActionContext.getContext().getSession().put("myPrepaidOrders", orders1);

        return orders;
    }

    @Override
    public List<OrderDisplay> getMyPrepaidOrders(int userId) {
        List<OrderDisplay> orders = userDao.getMyPrepaidOrders(userId);
        ActionContext.getContext().getSession().put("myPrepaidOrders", orders);

        return orders;
    }

    @Override
    public boolean modifyOrderStatus(int orderId) {
        return userDao.modifyOrderStatus(orderId);
    }

    @Override
    public User findUserByUserID(int userID){
        User user = userDao.findUserByUserID(userID);
        return user;
    }

    public List<User> getUserByLoginName(String username){
        List<User> users= userDao.findByName(username);
        return users;
    }
    @Override
    public boolean save(User user){
        return  userDao.save(user);
    }
    @Override
    public boolean modifyUser(User newuser) {
        return userDao.updateUser(newuser);
    }
    @Override
    public boolean updatePass(Long id, String newPassword) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Agent getAgentByPlot(int plotId) {
        Agent agent = userDao.getAgentByPlot(plotId);
        ActionContext.getContext().getSession().put("plotAgent", agent);

        return agent;
    }

    @Override
    public boolean savehouse(LandlordApplyRelease landlordApplyRelease){
        return  userDao.savehouse(landlordApplyRelease);
    }
    @Override
    public boolean messageSubmit(DiscussionSection discussionSection){return userDao.messageSubmit(discussionSection);}

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
    public boolean confirmHouse(House house,String phone, String user_name)
    {
        return  userDao.confirmHouse(house,phone, user_name);



    }

    @Override
    public void saveAgent(Agent agent, int userId, String username) {
        userDao.saveAgent(agent, userId, username);
    }
    @Override
    public boolean getUserByphone(String phone)
    {
        return userDao.getUserBYphone(phone);
    }

}
