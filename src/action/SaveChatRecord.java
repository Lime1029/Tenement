package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import model.Chat;
import service.ChatService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;

public class SaveChatRecord extends ActionSupport{
    private Chat chat;
    public void setChat(Chat chat){this.chat = chat;}
    public Chat getChat(){return chat;}
    private ChatService chatService;
    public ChatService getChatService(){return chatService;}
    public void setChatService(ChatService chatService){this.chatService = chatService;}
    private int senderID;
    public void setSenderID(int senderID){this.senderID = senderID;}
    public int getSenderID(){return senderID;}
    private String chatMessage;
    public void setChatMessage(String chatMessage){this.chatMessage = chatMessage;}
    public String getChatMessage(){return chatMessage;}
    private int userID;
    public void setUserID(int userID){this.userID = userID;}
    public int getUserID(){return userID;}
    private int agentID;
    public void setAgentID(int agentID){this.agentID = agentID;}
    public int getAgentID(){return agentID;}
    public InputStream inputStream;
    public void setInputStream(InputStream inputStream){this.inputStream = inputStream;}
    public InputStream getInputStream(){return inputStream;}
    @Override
    public String execute() throws Exception{
        String str = "成功发送";
        inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        chat.setSendTime(ts);
        chat.setAgentId(agentID);
        chat.setSenderId(senderID);
        chat.setUserId(userID);
        chat.setChatMessage(chatMessage);
        String isSave = chatService.save(chat);
        return isSave;
    }
}