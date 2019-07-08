package action;
import com.opensymphony.xwork2.ActionSupport;

import dao.AgentShowDao;

import static com.opensymphony.xwork2.Action.SUCCESS;

public class EndContract  extends ActionSupport {
    private int contractID;
    private AgentShowDao agentShowDao;

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public AgentShowDao getAgentShowDao() {
        return agentShowDao;
    }

    public void setAgentShowDao(AgentShowDao agentShowDao) {
        this.agentShowDao = agentShowDao;
    }

    public String execute(){
       int result =agentShowDao.endContract(contractID);
       if(result == 1){
           return SUCCESS;
       }
       return ERROR;
    }

}
