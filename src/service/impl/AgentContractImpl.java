package service.impl;

import dao.AgentShowDao;
import model.House;
import model.PageBean;
import org.springframework.stereotype.Service;
import service.AgentContractService;
import service.AgentShowService;

import java.util.List;

@Service("AgentShowService")
public class AgentContractImpl implements AgentContractService {
    private AgentShowDao agentShowDao;

    public void setAgentShowDao(AgentShowDao agentShowDao) {
        this.agentShowDao = agentShowDao;
    }
    //query for distract
    public PageBean queryForPage(int pageSize,int page){

        final String hql = "from House,Plot,district,agent where agent.agent_id = plot.agent_id and plot.distruct_id = district.district_id and house.plot_id = plot.plot_id;";        //查询语句
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

    public void updateHouseState(int houseid){

    }

}
