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
        int allRow = agentShowDao.getAllRowCount();    //�ܼ�¼��
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //��ҳ��
        final int offset = PageBean.countOffset(pageSize, page);    //��ǰҳ��ʼ��¼
        final int length = pageSize;    //ÿҳ��¼��
        final int currentPage = PageBean.countCurrentPage(page);
        List<House> list = agentShowDao.queryForPage(offset, length);        //"һҳ"�ļ�¼

        //�ѷ�ҳ��Ϣ���浽Bean��
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
        int allRow = agentShowDao.getAllContractCount();    //�ܼ�¼��
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //��ҳ��
        final int offset = PageBean.countOffset(pageSize, page);    //��ǰҳ��ʼ��¼
        final int length = pageSize;    //ÿҳ��¼��
        final int currentPage = PageBean.countCurrentPage(page);
        List<House> list = agentShowDao.queryForContract(offset, length);        //"һҳ"�ļ�¼

        //�ѷ�ҳ��Ϣ���浽Bean��
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