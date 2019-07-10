package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.House;
import model.User;
import service.SearchService;

import java.util.List;

public class KeywordSearch extends ActionSupport {
    private String resultMess = "error";
    private String condition;
    private SearchService searchService;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public SearchService getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }


    public String searchHouse() throws Exception {

        List<House> houses = searchService.keywordSearchHouse(condition);
        if(houses != null) {
            ActionContext.getContext().getSession().put("houses", houses);
            resultMess = "success";
        }


        return resultMess;
    }

    public String searchUser() throws Exception {

        List<User> users = searchService.keywordSearchUser(condition);
        ActionContext.getContext().getSession().put("users", users);
        resultMess = "success";

        return resultMess;
    }

    public String searchAgent() throws Exception {
        searchService.keywordSearchAgent(condition);

        resultMess = "success";

        return resultMess;
    }

    public String searchAdminHouse() throws Exception {
        searchService.keywordSearchAdminHouse(condition);
        return "success";
    }

    public String searchCity() throws Exception {
        searchService.searchCity(condition);
        return "success";
    }

    public String searchDistrict() throws Exception {
        searchService.searchDistrict(condition);
        return "success";
    }

    public String searchPlot() throws Exception {
        searchService.searchPlot(condition);
        return "success";
    }
}
