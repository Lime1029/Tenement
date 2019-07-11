package dao;

import model.*;

import java.util.List;

public interface UserDao {
    public boolean save(User user);
    public User getUserByTel(String telephone);
    public Agent getAgentByTel(String telephone);
    public Administrator getAdminByTel(String telephone);
    public List<HouseInfo> searchMyHouse(int userId);
    public List<HouseInfo> searchMyRentalHouse(int userId);
    public List<ContractInfo> getContract(int houseId);
    public List<ContractInfo> getContractAsTenant(int houseId, int userId);
    public List<OrderDisplay> getMyOutstandingOrders(int userId);
    public List<OrderDisplay> getMyPrepaidOrders(int userId);
    public boolean modifyOrderStatus(int orderId);
    public List<User> findByName(String username);
    public boolean updateUser(User user);
    public boolean updateUser(User user,String newpassword);
    public User findUserByUserID(int userID);
    public Agent getAgentByPlot(int plotId);

    public boolean savehouse(LandlordApplyRelease landlordApplyRelease);
    public boolean confirmHouse(House house,String phone, String user_name);
    public boolean messageSubmit(DiscussionSection discussionSection);
    public List getNotice();
    public List<Plot> getPlot();
    public List<Plot> plotGet();
    public int getHouse_userid(String phone);
    public boolean getUserBYphone(String phone);

    public void saveAgent(Agent agent, int userId, String username);
    public void addUserName(int userId, String username);
}
