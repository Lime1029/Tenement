package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class House {
    private int houseId;
    private int landlordId;
    private int plotId;
    private String address;
    private double rent;
    private int state;
    private String houseType;
    private String floor;
    private double area;
    private String houseDescription;
    private Timestamp releaseTime;
    private Integer rentalType;
    private Integer orientation;
    private String rentTerm;

    @Id
    @Column(name = "house_id")
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    @Basic
    @Column(name = "landlord_id")
    public int getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }

    @Basic
    @Column(name = "plot_id")
    public int getPlotId() {
        return plotId;
    }

    public void setPlotId(int plotId) {
        this.plotId = plotId;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "rent")
    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    @Basic
    @Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "house_type")
    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    @Basic
    @Column(name = "floor")
    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Basic
    @Column(name = "area")
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Basic
    @Column(name = "house_description")
    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }

    @Basic
    @Column(name = "release_time")
    public Timestamp getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Timestamp releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Basic
    @Column(name = "rentalType")
    public Integer getRentalType() {
        return rentalType;
    }

    public void setRentalType(Integer rentalType) {
        this.rentalType = rentalType;
    }

    @Basic
    @Column(name = "orientation")
    public Integer getOrientation() {
        return orientation;
    }

    public void setOrientation(Integer orientation) {
        this.orientation = orientation;
    }

    @Basic
    @Column(name = "rent_term")
    public String getRentTerm() {
        return rentTerm;
    }

    public void setRentTerm(String rentTerm) {
        this.rentTerm = rentTerm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return houseId == house.houseId &&
                landlordId == house.landlordId &&
                plotId == house.plotId &&
                Double.compare(house.rent, rent) == 0 &&
                state == house.state &&
                Double.compare(house.area, area) == 0 &&
                Objects.equals(address, house.address) &&
                Objects.equals(houseType, house.houseType) &&
                Objects.equals(floor, house.floor) &&
                Objects.equals(houseDescription, house.houseDescription) &&
                Objects.equals(releaseTime, house.releaseTime) &&
                Objects.equals(rentalType, house.rentalType) &&
                Objects.equals(orientation, house.orientation) &&
                Objects.equals(rentTerm, house.rentTerm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseId, landlordId, plotId, address, rent, state, houseType, floor, area, houseDescription, releaseTime, rentalType, orientation, rentTerm);
    }
}
