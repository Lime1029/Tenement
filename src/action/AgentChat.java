package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import model.Chat;
import service.ChatService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class AgentChat extends ActionSupport{
    private List<List<Chat>> users_chats;
    private ChatService chatService;
    public void setChatService(ChatService chatService){this.chatService = chatService;}
    public ChatService getChatService(){return chatService;}
    private UserService userService;
    public UserService getUserService() { return userService; }
    public void setUserService(UserService userService) { this.userService = userService; }
    private int agentID;
    public void setAgentID(int agentID){this.agentID = agentID;}
    public int getAgentID(){return agentID;}
    @Override
    public String execute(){
        users_chats = chatService.getChatByAgentID(agentID);
        List<String> usernames = new ArrayList<>();
        for(int i=0; i<users_chats.size();i++){
            int userID = users_chats.get(i).get(0).getUserId();
            usernames.add(userService.findUserByUserID(userID).getUsername());
        }
        ActionContext.getContext().getSession().put("users_chats",users_chats);
        ActionContext.getContext().getSession().put("user_names",usernames);
        return SUCCESS;
    }
}
