package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class HouseFacilityPK implements Serializable {
    private int houseId;
    private int facilityId;

    @Column(name = "house_id")
    @Id
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    @Column(name = "facility_id")
    @Id
    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseFacilityPK that = (HouseFacilityPK) o;
        return houseId == that.houseId &&
                facilityId == that.facilityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseId, facilityId);
    }
}
