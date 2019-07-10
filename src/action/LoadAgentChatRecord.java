package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import model.Chat;
import service.ChatService;

import java.util.List;

public class LoadAgentChatRecord extends ActionSupport{
    private List<Chat> chats;
    private ChatService chatService;
    public void setChatService(ChatService chatService){this.chatService = chatService;}
    public ChatService getChatService(){return chatService;}
    private int userID;
    public void setUserID(int userID){this.userID = userID;}
    public int getUserID(){return userID;}
    private int agentID;
    public void setAgentID(int agentID){this.agentID = agentID;}
    public int getAgentID(){return agentID;}
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String execute(){
        chats = chatService.getChatByUserIDAndAgentID(userID,agentID);
        ActionContext.getContext().getSession().put("chats",chats);
        if(type.equals("agent")){
            System.out.println(userID);
            ActionContext.getContext().getSession().put("userID",userID);
            type = "";
            System.out.println("agent");
            return "agent";
        }
        ActionContext.getContext().getSession().put("agentID",agentID);
        return SUCCESS;
    }
}