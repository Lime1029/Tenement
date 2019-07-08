package service;

import model.PageBean;

public interface AgentContractService {
    public PageBean queryForPage(int pageSize, int currentPage);
    public void updateHouseState(int houseid);
}