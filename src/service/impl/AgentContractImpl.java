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

        final String hql = "from House,Plot,district,agent where agent.agent_id = plot.agent_id and plot.distruct_id = district.district_id and house.plot_id = plot.plot_id;";        //��ѯ���
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

    public void updateHouseState(int houseid){

    }

}