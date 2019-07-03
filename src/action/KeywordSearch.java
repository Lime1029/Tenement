package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.House;
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


    public String execute() throws Exception {

        List<House> houses = searchService.keywordSearch(condition);
        if(houses != null) {
            ActionContext.getContext().getSession().put("houses", houses);
            resultMess = "success";
        }


        return resultMess;
    }
}
