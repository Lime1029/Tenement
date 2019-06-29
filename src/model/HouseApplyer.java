package model;

import javax.persistence.*;
import java.util.Objects;
import java.io.Serializable;

@Entity
@Table(name = "house_applyer", schema = "tenement", catalog = "")
@IdClass(HouseApplyerPK.class)
public class HouseApplyer implements Serializable {
    private int houseId;
    private int houseApplyerId;

    @Id
    @Column(name = "house_id")
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    @Id
    @Column(name = "house_applyer_id")
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
        HouseApplyer that = (HouseApplyer) o;
        return houseId == that.houseId &&
                houseApplyerId == that.houseApplyerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseId, houseApplyerId);
    }
}
