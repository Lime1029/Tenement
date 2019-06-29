package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Facility {
    private int facilityId;
    private String facility;

    @Id
    @Column(name = "facility_id")
    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    @Basic
    @Column(name = "facility")
    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility1 = (Facility) o;
        return facilityId == facility1.facilityId &&
                Objects.equals(facility, facility1.facility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facilityId, facility);
    }
}
