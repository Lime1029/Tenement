package dao;

import model.User;
import model.Administrator;
import model.Agent;

public interface UserDao {
    public boolean save(User user);
    public User getUserByTel(String telephone);
    public Agent getAgentByTel(String telephone);
    public Administrator getAdminByTel(String telephone);
    public User findByLoginName(String username);
    public boolean updateUser(User user);
    public boolean updateUser(User user,String newpassword);
}
