package service;

import model.Chat;
import model.PageBean;

import java.util.List;

public interface ChatService {
    public List<Chat> getChatByUserIDAndAgentID(int userID, int agentID);
    public List<List<Chat>> getChatByAgentID(int agentID);
    public String save(Chat chat);

    interface AgentShowService {
        public PageBean queryForPage(int pageSize, int currentPage);
        public int getAllRowCount();
        public PageBean queryForContract(int pageSize, int currentPage);
        public int getAllContractCount();
    }
}