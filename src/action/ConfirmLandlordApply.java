package action;

import com.opensymphony.xwork2.ActionSupport;
import service.AgentService;

public class ConfirmLandlordApply extends ActionSupport {
    private AgentService agentService;
    private int applyId;

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public AgentService getAgentService() {
        return agentService;
    }

    public void setAgentService(AgentService agentService) {
        this.agentService = agentService;
    }


    public String getLandlordApply() throws Exception {
        agentService.getLandlordApply();
        return "success";
    }

    public String approveLandlordApply() throws Exception {
        agentService.deleteLandlordApply(applyId);
        return "success";
    }
}
