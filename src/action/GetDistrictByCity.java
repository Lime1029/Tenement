package action;


import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


public class GetDistrictByCity extends ActionSupport {
    private AdminService adminService;

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }



    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String cityId = request.getParameter("cityId");
        System.out.println("cityId："  + cityId);
        adminService.getDistrictByCity(Integer.parseInt(cityId));

        //将数据存储在map里，再转换成json类型数据
       /* Map<String,Object> map = new HashMap<String, Object>();
        map.put("featureGen", featureGen);
        map.put("featureJing",featureJing);
        map.put("featureYe", featureYe);

        JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
        result = json.toString();//给result赋值，传递给页面*/

        return "success";
    }
}
