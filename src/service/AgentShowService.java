package service;

import model.PageBean;

import java.util.List;

public interface AgentShowService {
    public PageBean queryForPage(int pageSize,int currentPage);
}
