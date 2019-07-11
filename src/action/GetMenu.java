package action;


import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class GetMenu extends ActionSupport {
    private AdminService adminService;
    private InputStream inputStream;
    private int cityId;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }



    public String getDistrictByCity() throws Exception {
        String str = "成功发送";
        inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
        adminService.getDistrictByCity(cityId);
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
