package service;

import model.Agent;
import model.LandlordApplyRelease;

import java.util.List;

public interface AgentService {
    public List<Agent> getAgentByAgentName(String name);
    public List<LandlordApplyRelease> getLandlordApply();
    public boolean deleteLandlordApply(int applyId);
}