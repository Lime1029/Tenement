package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class HouseApplyerPK implements Serializable {
    private int houseId;
    private int houseApplyerId;

    @Column(name = "house_id")
    @Id
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    @Column(name = "house_applyer_id")
    @Id
    public int getHouseApplyerId() {
        return houseApplyerId;
    }

    public void setHouseApplyerId(int houseApplyerId) {
        this.houseApplyerId = houseApplyerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseApplyerPK that = (HouseApplyerPK) o;
        return houseId == that.houseId &&
                houseApplyerId == that.houseApplyerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseId, houseApplyerId);
    }
}
