package service;

import model.PageBean;

import java.util.List;

public interface AgentShowService {
    public PageBean queryForPage(int pageSize,int currentPage);
    public int getAllRowCount();
    public PageBean queryForContract(int pageSize,int currentPage);
    public int getAllContractCount();
}