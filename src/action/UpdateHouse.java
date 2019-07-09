package action;

import com.opensymphony.xwork2.ActionSupport;
import model.HouseInfo;
import service.UpdateService;

public class UpdateHouse extends ActionSupport {
    private String resultMess = "error";
    private String plotname;
 //   private String districtname;
    private String landlordName;
    private String address;
    private double rent;
    private String housetype;
    private String floor;
    private double area;
    private String housedescription;
  //  private String agentname;
    private int houseID;
    private UpdateService updateService;
    private HouseInfo houseInfor;
    public String getPlotname() {
        return plotname;
    }

    public void setPlotname(String plotname) {
        this.plotname = plotname;
    }



    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public HouseInfo getHouseInfor() {
        return houseInfor;
    }

    public void setHouseInfor(HouseInfo houseInfor) {
        this.houseInfor = houseInfor;
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

    public String getResultMess() {
        return resultMess;
    }

    public void setResultMess(String resultMess) {
        this.resultMess = resultMess;
    }

    public HouseInfo getHouseInfo() {
        return houseInfor;
    }

    public void setHouseInfo(HouseInfo houseInfo) {
        this.houseInfor = houseInfo;
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
    @Override
    public String execute(){
        /*
        houseInfor.setAddress(address);
        houseInfor.setArea(area);
        houseInfor.setHouseId(houseID);

      **/
        houseInfor =new HouseInfo(plotname,null,null,address,rent,housetype,floor,area,housedescription,0,houseID);
        String resultMess = updateService.updateHouse(this.houseInfor);
        return  resultMess;
    }
}