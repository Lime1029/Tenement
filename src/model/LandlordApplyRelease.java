package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "landlord_apply_release", schema = "tenement", catalog = "")
public class LandlordApplyRelease {
    private int applyId;
    private int applyerId;
    private String address;
    private double expectPrice;
    private String applyerPhone;
    private String applyerAppellation;
    private Timestamp applyTime;
    private int plotId;

    @Id
    @Column(name = "apply_id")
    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    @Basic
    @Column(name = "applyer_id")
    public int getApplyerId() {
        return applyerId;
    }

    public void setApplyerId(int applyerId) {
        this.applyerId = applyerId;
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
    @Column(name = "expect_price")
    public double getExpectPrice() {
        return expectPrice;
    }

    public void setExpectPrice(double expectPrice) {
        this.expectPrice = expectPrice;
    }

    @Basic
    @Column(name = "applyer_phone")
    public String getApplyerPhone() {
        return applyerPhone;
    }

    public void setApplyerPhone(String applyerPhone) {
        this.applyerPhone = applyerPhone;
    }

    @Basic
    @Column(name = "applyer_appellation")
    public String getApplyerAppellation() {
        return applyerAppellation;
    }

    public void setApplyerAppellation(String applyerAppellation) {
        this.applyerAppellation = applyerAppellation;
    }

    @Basic
    @Column(name = "apply_time")
    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    @Basic
    @Column(name = "plot_id")
    public int getPlotId() {
        return plotId;
    }

    public void setPlotId(int plotId) {
        this.plotId = plotId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LandlordApplyRelease that = (LandlordApplyRelease) o;
        return applyId == that.applyId &&
                applyerId == that.applyerId &&
                Double.compare(that.expectPrice, expectPrice) == 0 &&
                plotId == that.plotId &&
                Objects.equals(address, that.address) &&
                Objects.equals(applyerPhone, that.applyerPhone) &&
                Objects.equals(applyerAppellation, that.applyerAppellation) &&
                Objects.equals(applyTime, that.applyTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applyId, applyerId, address, expectPrice, applyerPhone, applyerAppellation, applyTime, plotId);
    }
}
