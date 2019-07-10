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
    //ͨ��applicationContext.xml�����ļ�ע��AgentShowService��ֵ
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

    private int page;    //�ڼ�ҳ

    private PageBean pageBean;    //�����ֲ���Ϣ��bean

    public int getPage() {
        return page;
    }
    public void setPage(int page) {        //��URL���޴˲���,��Ĭ��Ϊ��1ҳ
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
        //��ҳ��pageBean,����pageSize��ʾÿҳ��ʾ��¼��,pageΪ��ǰҳ
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
            //    PageBean page = new PageBean(this.pageBean.getCurrentPage(), agentShowService.getAllRowCount(),5);// ʵ������ҳ����
            //  request.put("page", page);// ���浽request
            session.put("aaaa",aaaa);

            return SUCCESS;
        }
        return ERROR;
    }
}