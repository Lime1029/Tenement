package service;

import model.Administrator;
import model.Agent;
import model.User;

public interface UserService {
    public User getUserByTel(String telephone);
    public Agent getAgentByTel(String telephone);
    public Administrator getAdminByTel(String telephone);
    public User getUserByLoginName(String username);//判断用户名是否存在
    public boolean save(User user);//注册
    public boolean modifyUser(User newuser);//修改用户信息
    public boolean updatePass(Long id,String newPassword);//修改密码

}
