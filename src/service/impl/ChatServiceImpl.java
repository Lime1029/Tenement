package service.impl;

import model.Chat;
import service.ChatService;
import org.springframework.stereotype.Service;
import dao.ChatDao;
import java.util.List;

@Service("ChatService")
public class ChatServiceImpl implements ChatService {
    private ChatDao chatDao;
    public void setChatDao(ChatDao chatDao){this.chatDao = chatDao;}
    public ChatDao getChatDao(){return chatDao;}
    @Override
    public List<Chat> getChatByUserIDAndAgentID(int userID, int agentID){
        List<Chat>chats = chatDao.getChatByUserIDAndAgentID(userID,agentID);
        return chats;
    }
    @Override
    public List<List<Chat>> getChatByAgentID(int agentID){
        List<List<Chat>> user_chats = chatDao.getChatByAgentID(agentID);
        return user_chats;
    }
    @Override
    public String save(Chat chat){
        String isSave = chatDao.save(chat);
        return isSave;
    }
}