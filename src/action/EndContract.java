package action;
import com.opensymphony.xwork2.ActionSupport;

import dao.AgentShowDao;

import static com.opensymphony.xwork2.Action.SUCCESS;

public class EndContract  extends ActionSupport {
    int contractID;
    private AgentShowDao agentShowDao;
    public String execute(){
       int result =agentShowDao.endContract(contractID);
       if(result == 1){
           return SUCCESS;
       }
       return ERROR;
    }

}
