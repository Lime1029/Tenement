package action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import model.PageBean;
import service.AgentShowService;
import service.UserService;

import java.util.List;
import java.util.Map;

public class getMyHouse extends ActionSupport {
    //通过applicationContext.xml配置文件注入AgentShowService的值
    private AgentShowService agentShowService;
    private UserService userService;
    private List plot;

    public AgentShowService getAgentShowService() {
        return agentShowService;
    }

    public List getPlot() {
        return plot;
    }

    public void setPlot(List plot) {
        this.plot = plot;
    }

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

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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
        userService.plotGet();

        this.pageBean = agentShowService.queryForPage(2, page);
        int a = this.pageBean.getAllRow();
        if(a>0){
            Map session = ActionContext.getContext().getSession();
            Map request = (Map) ActionContext.getContext().get("request");
            session.put("pageBean",pageBean);
            //    PageBean page1 = session.get(pageBean);
            //    List aa =(List)page1.getList();
            //   session.put("aa",aa);
            List aaaa = this.pageBean.getList();

            List aaa = (List)session.get(pageBean.getList());
            //    PageBean page = new PageBean(this.pageBean.getCurrentPage(), agentShowService.getAllRowCount(),5);// 实例化分页对象
            //  request.put("page", page);// 保存到request
            session.put("aaaa",aaaa);

            return SUCCESS;
        }
        return ERROR;
    }
}