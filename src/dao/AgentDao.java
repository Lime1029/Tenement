package dao;

import model.Agent;

import java.util.List;

public interface AgentDao {
    public List<Agent> getAgentByAgentName(String name);
}