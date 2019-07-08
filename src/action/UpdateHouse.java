package action;

import com.opensymphony.xwork2.ActionSupport;
import model.HouseInfo;
import service.UpdateService;

public class UpdateHouse extends ActionSupport {
    private String resultMess = "error";
    private String plotname;
    private String districtname;
    private String landlordName;
    private String address;
    private double rent;
    private String housetype;
    private String floor;
    private double area;
    private String housedescription;
    private String agentname;
    private int houseID;
    private UpdateService updateService;
    private HouseInfo houseInfo;
    public String getPlotname() {
        return plotname;
    }

    public void setPlotname(String plotname) {
        this.plotname = plotname;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getHousedescription() {
        return housedescription;
    }

    public void setHousedescription(String housedescription) {
        this.housedescription = housedescription;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }

    public UpdateService getUpdateService() {
        return updateService;
    }

    public void setUpdateService(UpdateService updateService) {
        this.updateService = updateService;
    }

    public String excute(){
        houseInfo =new HouseInfo(plotname,districtname,agentname,address,rent,housetype,floor,area,housedescription,0,houseID);
        String resultMess = updateService.updateHouse(this.houseInfo);
        return  resultMess;
    }
}
