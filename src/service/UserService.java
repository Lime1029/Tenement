package service;

import model.*;

import java.util.List;

public interface UserService {
    public User getUserByTel(String telephone);
    public Agent getAgentByTel(String telephone);
    public Administrator getAdminByTel(String telephone);
    public User getUserByLoginName(String username);//判断用户名是否存在
    public boolean save(User user);//注册
    public boolean modifyUser(User newuser);//修改用户信息
    public boolean updatePass(Long id,String newPassword);//修改密码
    public boolean savehouse(LandlordApplyRelease landlordApplyRelease);//房东提交房源
    public boolean confirmHouse(House house,String phone);//经纪人确认房源
    public boolean messageSubmit(DiscussionSection discussionSection);//讨论块
    public List messageSave();
    public void plotSave();
    public void plotGet();
    public void houseSave(String phone);

}
