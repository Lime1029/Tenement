package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "house_facility", schema = "tenement", catalog = "")
@IdClass(HouseFacilityPK.class)
public class HouseFacility implements Serializable {
    private int houseId;
    private int facilityId;
    private byte isExist;

    @Id
    @Column(name = "house_id")
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    @Id
    @Column(name = "facility_id")
    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    @Basic
    @Column(name = "is_exist")
    public byte getIsExist() {
        return isExist;
    }

    public void setIsExist(byte isExist) {
        this.isExist = isExist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseFacility that = (HouseFacility) o;
        return houseId == that.houseId &&
                facilityId == that.facilityId &&
                isExist == that.isExist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseId, facilityId, isExist);
    }
}
