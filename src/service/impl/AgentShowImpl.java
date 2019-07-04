package service.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.AdminDao;
import dao.AgentShowDao;
import model.User;
import org.springframework.stereotype.Service;
import service.AdminService;
import service.AgentShowService;
import model.PageBean;
import java.util.List;

@Service("AdminService")
public class AgentShowImpl implements AgentShowService {
    private AgentShowDao agentShowDao;

    public void setAgentShowDao(AgentShowDao agentShowDao) {
        this.agentShowDao = agentShowDao;
    }

    public PageBean queryForPage(int pageSize,int page){
        final String hql = "from Member";        //查询语句
        int allRow = memberDao.getAllRowCount(hql);    //总记录数
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录
        final int length = pageSize;    //每页记录数
        final int currentPage = PageBean.countCurrentPage(page);
        List<Member> list = memberDao.queryForPage(hql,offset, length);        //"一页"的记录

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


}
