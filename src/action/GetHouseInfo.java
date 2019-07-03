package action;

import com.opensymphony.xwork2.ActionSupport;
import model.HouseInfo;
import service.SearchService;

public class GetHouseInfo extends ActionSupport {
    private String resultMess = "error";
    private SearchService searchService;
    private int houseId;

    public SearchService getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String execute() throws Exception {
        System.out.println(houseId);
        HouseInfo house1 = searchService.getHouseInfo(this.getHouseId());
        if (house1 != null) {
            resultMess = "success";
        }

        return resultMess;
    }
}
