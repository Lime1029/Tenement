package dao;

import model.*;
import model.LandlordApplyRelease;

import java.util.List;

public interface UserDao {
    public boolean save(User user);
    public User getUserByTel(String telephone);
    public Agent getAgentByTel(String telephone);
    public Administrator getAdminByTel(String telephone);
    public User findByLoginName(String username);
    public boolean updateUser(User user);
    public boolean updateUser(User user,String newpassword);
    public boolean savehouse(LandlordApplyRelease landlordApplyRelease);
    public boolean confirmHouse(House house,String phone);
    public boolean messageSubmit(DiscussionSection discussionSection);
    public List getNotice();
    public List<Plot> getPlot();
    public List<Plot> plotGet();
    public int getHouse_userid(String phone);
}
