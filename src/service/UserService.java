package service;

import model.*;

import java.util.List;

public interface UserService {
    public User getUserByTel(String telephone);
    public Agent getAgentByTel(String telephone);
    public Administrator getAdminByTel(String telephone);
    public List<HouseInfo> searchMyHouse(int userId);
    public List<HouseInfo> searchMyRentalHouse(int userId);
    public List<ContractInfo> getMyContract(int houseId);
    public List<ContractInfo> getContractAsTenant(int houseId, int userId);
    public List<OrderDisplay> getMyOutstandingOrders(int userId);
    public List<OrderDisplay> getMyPrepaidOrders(int userId);
    public boolean modifyOrderStatus(int orderId);
    public List<User> getUserByLoginName(String username);//判断用户名是否存在
    public boolean save(User user);//注册
    public boolean modifyUser(User newUser);//修改用户信息
    public boolean updatePass(Long id,String newPassword);//修改密码
    public User findUserByUserID(int userID);
    public Agent getAgentByPlot(int plotId);

    public boolean savehouse(LandlordApplyRelease landlordApplyRelease);//房东提交房源
    public boolean confirmHouse(House house,String phone, String user_name);//经纪人确认房源
    public boolean messageSubmit(DiscussionSection discussionSection);//讨论块
    public List messageSave();
    public void plotSave();
    public void plotGet();
    public void houseSave(String phone);
    public boolean getUserByphone(String phone);

    public void saveAgent(Agent agent, int userId, String username);

}
