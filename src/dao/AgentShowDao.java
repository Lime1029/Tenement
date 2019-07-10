package dao;

import model.House;
import model.PageBean;

import java.util.List;

public interface AgentShowDao {

    public List queryForPage(final int offset,final int length);
    public List queryForContract(final int offset,final int length);

    /** *//**
     * ��ѯ���м�¼��
     * @param hql ��ѯ������
     * @return �ܼ�¼��
     */
    public int getAllRowCount();
    public int getAllContractCount();
    public int endContract(int contractID);

}