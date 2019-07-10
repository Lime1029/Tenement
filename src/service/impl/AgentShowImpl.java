package service.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.AdminDao;
import dao.AgentShowDao;
import model.Agent;
import model.House;
import model.User;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import service.AdminService;
import service.AgentShowService;
import model.PageBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import model.HouseInfo;
@Service("AgentShowService")
public class AgentShowImpl implements AgentShowService {
    private AgentShowDao agentShowDao;

    public void setAgentShowDao(AgentShowDao agentShowDao) {
        this.agentShowDao = agentShowDao;
    }
    //query for distract
    public PageBean queryForPage(int pageSize,int page){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        Agent agent = (Agent)request.getSession().getAttribute("Agent");
        //String sqq = hql + "1";
        //(String)agent.getTelephone();
        int allRow = agentShowDao.getAllRowCount();    //总记录数
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录
        final int length = pageSize;    //每页记录数
        final int currentPage = PageBean.countCurrentPage(page);
        List<House> list = agentShowDao.queryForPage(offset, length);        //"一页"的记录

        //把分页信息保存到Bean中
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.init();
        return pageBean;
    }
    public PageBean queryForContract(int pageSize,int page){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        Agent agent = (Agent)request.getSession().getAttribute("agent");
        //String sqq = hql + "1";
        //(String)agent.getTelephone();
        int allRow = agentShowDao.getAllContractCount();    //总记录数
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录
        final int length = pageSize;    //每页记录数
        final int currentPage = PageBean.countCurrentPage(page);
        List<House> list = agentShowDao.queryForContract(offset, length);        //"一页"的记录

        //把分页信息保存到Bean中
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.init();
        return pageBean;
    }
    public int getAllRowCount(){

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        Agent agent = (Agent)request.getSession().getAttribute("Agent");

        // String sqq = hql + (String)agent.getTelephone();
        return this.agentShowDao.getAllRowCount();
    }
    public int getAllContractCount(){

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        Agent agent = (Agent)request.getSession().getAttribute("Agent");

        // String sqq = hql + (String)agent.getTelephone();
        return this.agentShowDao.getAllContractCount();
    }
}