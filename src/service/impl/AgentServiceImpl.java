package service.impl;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.AgentDao;
import dao.HouseDao;
import model.LandlordApplyRelease;
import org.springframework.stereotype.Service;
import service.AgentService;
import model.Agent;
import java.util.List;

@Service("AgentService")
public class AgentServiceImpl implements AgentService {
    private AgentDao agentDao;
    private HouseDao houseDao;

    public void setAgentDao(AgentDao agentDao) {
        this.agentDao = agentDao;
    }

    public AgentDao getAgentDao() {
        return agentDao;
    }

    public HouseDao getHouseDao() {
        return houseDao;
    }

    public void setHouseDao(HouseDao houseDao) {
        this.houseDao = houseDao;
    }

    @Override
    public List<Agent> getAgentByAgentName(String name){
        List<Agent> agents = agentDao.getAgentByAgentName(name);
        return agents;
    }

    @Override
    public List<LandlordApplyRelease> getLandlordApply() {
        List<LandlordApplyRelease> landlordApplyReleases = houseDao.getLandlordApply();
        ActionContext.getContext().getSession().put("landlordApply", landlordApplyReleases);
        return landlordApplyReleases;
    }

    @Override
    public boolean deleteLandlordApply(int applyId) {
        return houseDao.deleteLandlordApply(applyId);
    }
}