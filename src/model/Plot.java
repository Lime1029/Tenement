package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Plot {
    private int plotId;
    private String plotName;
    private int districtId;
    private int agentId;

    @Id
    @Column(name = "plot_id")
    public int getPlotId() {
        return plotId;
    }

    public void setPlotId(int plotId) {
        this.plotId = plotId;
    }

    @Basic
    @Column(name = "plot_name")
    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    @Basic
    @Column(name = "district_id")
    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    @Basic
    @Column(name = "agent_id")
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
        Plot plot = (Plot) o;
        return plotId == plot.plotId &&
                districtId == plot.districtId &&
                agentId == plot.agentId &&
                Objects.equals(plotName, plot.plotName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plotId, plotName, districtId, agentId);
    }
}
