package service;

import model.Chat;

import java.util.List;

public interface ChatService {
    public List<Chat> getChatByUserIDAndAgentID(int userID, int agentID);
    public List<List<Chat>> getChatByAgentID(int agentID);
    public String save(Chat chat);
}
