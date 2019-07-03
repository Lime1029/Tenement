package model;

import java.io.Serializable;
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

    public HouseInfo() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseInfo house = (HouseInfo) o;
        return Double.compare(house.rent, rent) == 0 &&
                Double.compare(house.area, area) == 0 &&
                Objects.equals(address, house.address) &&
                Objects.equals(houseType, house.houseType) &&
                Objects.equals(floor, house.floor) &&
                Objects.equals(houseDescription, house.houseDescription) &&
                Objects.equals(agentName, house.agentName) &&
                Objects.equals(plotName, house.plotName) &&
                Objects.equals(districtName, house.districtName) &&
                Objects.equals(agentId, house.agentId) &&
                Objects.equals(houseId, house.houseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plotName, agentName, districtName, address, rent, houseType, floor, area, houseDescription, agentId, houseId);
    }
}
