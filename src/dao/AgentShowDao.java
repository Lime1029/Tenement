package dao;

import model.House;
import model.PageBean;

import java.util.List;

public interface AgentShowDao {

    public List queryForPage(final int offset,final int length);
    public List queryForContract(final int offset,final int length);

    /** *//**
     * 查询所有记录数
     * @param hql 查询的条件
     * @return 总记录数
     */
    public int getAllRowCount();
    public int getAllContractCount();
    public int endContract(int contractID);

}