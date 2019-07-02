package service.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.AdminDao;
import model.User;
import org.springframework.stereotype.Service;
import service.AdminService;

import java.util.List;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao;

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = adminDao.getAllUsers();
        ActionContext.getContext().getSession().put("users", users);
        return users;
    }
}
