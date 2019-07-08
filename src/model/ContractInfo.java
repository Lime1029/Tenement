package model;

import java.io.Serializable;
import java.util.Date;

public class ContractInfo implements Serializable {
    private int contractId;
    private Date stime;
    private Date etime;
    private String tenant;
    private String landlord;
    private String plotName;
    private String districtName;
    private String agentName;
    private String address;
    private double rent;
    private String houseType;
    private double area;
    private String houseDescription;
    private String landlordTel;
    private String tenantTel;

    public ContractInfo() {
    }

    public ContractInfo(Date stime, Date etime, String tenant, String landlord, String agentName, double rent,
                        double area,String houseType, String districtName, String plotName, String address, String houseDescription
    ,String landlordTel, String tenantTel) {
        super();
        this.stime = stime;
        this.etime = etime;
        this.tenant = tenant;
        this.landlord = landlord;
        this.plotName = plotName;
        this.districtName = districtName;
        this.agentName = agentName;
        this.address = address;
        this.rent = rent;
        this.houseType = houseType;
        this.area = area;
        this.houseDescription = houseDescription;
        this.landlordTel = landlordTel;
        this.tenantTel = tenantTel;
    }

    public String getLandlordTel() {
        return landlordTel;
    }

    public void setLandlordTel(String landlordTel) {
        this.landlordTel = landlordTel;
    }

    public String getTenantTel() {
        return tenantTel;
    }

    public void setTenantTel(String tenantTel) {
        this.tenantTel = tenantTel;
    }

    public Date getStime() {
        return stime;
    }

    public Date getEtime() {
        return etime;
    }

    public String getTenant() {
        return tenant;
    }

    public String getLandlord() {
        return landlord;
    }

    public String getPlotName() {
        return plotName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getAddress() {
        return address;
    }

    public double getRent() {
        return rent;
    }

    public String getHouseType() {
        return houseType;
    }

    public double getArea() {
        return area;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public void setLandlord(String landlord) {
        this.landlord = landlord;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }
}
