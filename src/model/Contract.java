package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Contract {
    private int contractId;
    private Date stime;
    private Date etime;
    private int agentId;
    private int tenantId;
    private int lanlordId;
    private int houseId;


    @Id
    @Column(name = "contract_id")
    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    @Basic
    @Column(name = "stime")
    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    @Basic
    @Column(name = "etime")
    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }


    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    @Basic
    @Column(name = "tenant_id")
    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }


    public int getLanlordId() {
        return lanlordId;
    }

    public void setLanlordId(int lanlordId) {
        this.lanlordId = lanlordId;
    }

    @Basic
    @Column(name = "house_id")
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return contractId == contract.contractId &&
                agentId == contract.agentId &&
                tenantId == contract.tenantId &&
                lanlordId == contract.lanlordId &&
                houseId == contract.houseId &&
                Objects.equals(stime, contract.stime) &&
                Objects.equals(etime, contract.etime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, stime, etime, agentId, tenantId, lanlordId, houseId);
    }
}
