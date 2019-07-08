package action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.House;
import service.SearchService;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.House;
import service.SearchService;

import java.util.List;

public class ConditionSearch extends ActionSupport {
    private String resultMess = "error";
    private House housing;
    private SearchService searchService;

    private int housing_plot;
    private String housing_district;
    private Double housing_maxrent ;
    private Double housing_leastrent;
    private String housing_type;

    public String getHousing_district() {
        return housing_district;
    }

    public int getHousing_plot() {
        return housing_plot;
    }

    public void setHousing_plot(int housing_plot) {
        this.housing_plot = housing_plot;
    }

    public void setHousing_district(String housing_district) {
        this.housing_district = housing_district;
    }

    public void setHousing_maxrent(Double housing_maxrent) {
        this.housing_maxrent = housing_maxrent;
    }

    public void setHousing_leastrent(Double housing_leastrent) {
        this.housing_leastrent = housing_leastrent;
    }

    public void setHousing_type(String housing_type) {
        this.housing_type = housing_type;
    }

    public Double getHousing_maxrent() {
        return housing_maxrent;
    }

    public Double getHousing_leastrent() {
        return housing_leastrent;
    }

    public String getHousing_type() {
        return housing_type;
    }

    public House getHousing() {
           return housing;    }

    public void setHousing(House housing) {
        this.housing = housing;
    }

    public SearchService getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }


    public String execute() throws Exception {
        housing = new House(1111,1,housing_plot,housing_district,housing_maxrent,1,housing_type,"4",housing_leastrent,"sa");
        /**
        this.housing.setLandlordId(1);
        this.housing.setPlotId(this.housing_plot);
        this.housing.setHouseType(this.housing_type);

        this.housing.setRent(this.housing_maxrent);
        this.housing.setAddress(this.housing_district);
        this.housing.setArea(this.housing_leastrent);
**/
        List<House> houses = searchService.conditionSearch(this.housing);
        if(houses != null) {
            ActionContext.getContext().getSession().put("houses", houses);
            resultMess = "success";
        }
        return resultMess;
    }
}
