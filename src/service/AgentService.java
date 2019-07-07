package service;

import model.Agent;

import java.util.List;

public interface AgentService {
    public List<Agent> getAgentByAgentName(String name);
}
