package action;
import com.opensymphony.xwork2.ActionSupport;

import model.PageBean;
import service.AgentShowService;

public class getMyHouse extends ActionSupport {
    //通过applicationContext.xml配置文件注入AgentShowService的值
    private AgentShowService agentShowService;
    public void setAgentShowService(AgentShowService agentShowService) {
        this.agentShowService = agentShowService;
    }

    private int page;    //第几页

    private PageBean pageBean;    //包含分布信息的bean

    public int getPage() {
        return page;
    }
    public void setPage(int page) {        //若URL中无此参数,会默认为第1页
        this.page = page;
    }
    public PageBean getPageBean() {
        return pageBean;
    }
    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }
    @Override
    public String execute() throws Exception {
        //分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
        this.pageBean = agentShowService.queryForPage(2, page);
        return SUCCESS;
    }
}
