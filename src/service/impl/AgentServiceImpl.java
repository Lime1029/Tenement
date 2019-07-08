package service.impl;


import dao.AgentDao;
import org.springframework.stereotype.Service;
import service.AgentService;
import model.Agent;
import java.util.List;

@Service("AgentService")
public class AgentServiceImpl implements AgentService {
    private AgentDao agentDao;

    public void setAgentDao(AgentDao agentDao) {
        this.agentDao = agentDao;
    }

    public AgentDao getAgentDao() {
        return agentDao;
    }

    @Override
    public List<Agent> getAgentByAgentName(String name){
        List<Agent> agents = agentDao.getAgentByAgentName(name);
        return agents;
    }
}