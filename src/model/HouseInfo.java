package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class HouseInfo implements Serializable {
    private String plotName;
    private String districtName;
    private String agentName;
    private String address;
    private double rent;
    private String houseType;
    private String floor;
    private double area;
    private String houseDescription;
    private int agentId;
    private int houseId;
    private Date releaseTime;
    private String agentTel;
    private int state;
    private byte isSellOn;
    private String landlordName;
    private String landlordTel;


    public HouseInfo() {

    }
    //houseInfo页面所需
    public HouseInfo(String plotName, String districtName, String agentName, String address, double rent,
         String houseType, String floor, double area, String houseDescription, int agentId, int houseId, Date releaseTime) {

        super();
        this.address = address;
        this.agentName = agentName;
        this.area = area;
        this.districtName = districtName;
        this.floor = floor;
        this.houseDescription = houseDescription;
        this.houseType = houseType;
        this.rent = rent;
        this.plotName = plotName;
        this.agentId = agentId;
        this.houseId = houseId;
        this.releaseTime = releaseTime;
    }

    public HouseInfo(String plotName, String districtName, String agentName, String address, double rent,
                     String houseType, String floor, double area, String houseDescription, int agentId, int houseId) {

        super();
        this.address = address;
        this.agentName = agentName;
        this.area = area;
        this.districtName = districtName;
        this.floor = floor;
        this.houseDescription = houseDescription;
        this.houseType = houseType;
        this.rent = rent;
        this.plotName = plotName;
        this.agentId = agentId;
        this.houseId = houseId;
    }

    //用户个人中心查看名下房源所需
    public HouseInfo(String districtName, String plotName, String address, String agentName, double rent, int state,
                     String houseType, String floor, double area, Date releaseTime, int houseId, String agentTel) {

        super();
        this.address = address;
        this.agentName = agentName;
        this.area = area;
        this.districtName = districtName;
        this.floor = floor;
        this.houseType = houseType;
        this.rent = rent;
        this.state = state;
        this.plotName = plotName;
        this.agentTel = agentTel;
        this.houseId = houseId;
        this.releaseTime = releaseTime;
    }

    //用户个人中心查看所租房屋所需
    public HouseInfo(String districtName, String plotName, String address, String agentName, double rent, int state,
                     String houseType, String floor, double area, Date releaseTime, int houseId, String agentTel,  byte isSellOn) {

        super();
        this.address = address;
        this.agentName = agentName;
        this.area = area;
        this.districtName = districtName;
        this.floor = floor;
        this.houseType = houseType;
        this.rent = rent;
        this.state = state;
        this.plotName = plotName;
        this.agentTel = agentTel;
        this.houseId = houseId;
        this.releaseTime = releaseTime;
        this.isSellOn = isSellOn;
    }

    //管理员端查看房屋信息
    public HouseInfo(String plotName, String districtName, String agentName, String address, double rent, String houseType, String floor, double area, int agentId, int houseId, Date releaseTime, String agentTel, int state, String landlordName, String landlordTel) {
        this.plotName = plotName;
        this.districtName = districtName;
        this.agentName = agentName;
        this.address = address;
        this.rent = rent;
        this.houseType = houseType;
        this.floor = floor;
        this.area = area;
        this.agentId = agentId;
        this.houseId = houseId;
        this.releaseTime = releaseTime;
        this.agentTel = agentTel;
        this.state = state;
        this.landlordName = landlordName;
        this.landlordTel = landlordTel;
    }

    public int getIsSellOn() {
        return isSellOn;
    }

    public void setIsSellOn(byte isSellOn) {
        this.isSellOn = isSellOn;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
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

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
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

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getAgentTel() {
        return agentTel;
    }

    public int getState() {
        return state;
    }

    public void setAgentTel(String agentTel) {
        this.agentTel = agentTel;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String lanlordName) {
        this.landlordName = lanlordName;
    }

    public String getLandlordTel() {
        return landlordTel;
    }

    public void setLandlordTel(String landlordTel) {
        this.landlordTel = landlordTel;
    }
}
