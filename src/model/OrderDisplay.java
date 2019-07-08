package model;

import java.io.Serializable;
import java.util.Date;

public class OrderDisplay implements Serializable {
    private String landlord;
    private String lanlordTel;
    private String agent;
    private String agentTel;
    private Date stime;
    private Date etime;
    private int rent;
    private int orderId;

    public OrderDisplay() {
    }

    public OrderDisplay(String landlord, String lanlordTel, String agent,
                        String agentTel, Date stime, Date etime, int rent, int orderId) {
        super();
        this.landlord = landlord;
        this.lanlordTel = lanlordTel;
        this.agent = agent;
        this.agentTel = agentTel;
        this.stime = stime;
        this.etime = etime;
        this.rent = rent;
        this.orderId = orderId;
    }

    public String getLandlord() {
        return landlord;
    }

    public String getLanlordTel() {
        return lanlordTel;
    }

    public String getAgent() {
        return agent;
    }

    public String getAgentTel() {
        return agentTel;
    }

    public Date getStime() {
        return stime;
    }

    public Date getEtime() {
        return etime;
    }

    public int getRent() {
        return rent;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setLandlord(String landlord) {
        this.landlord = landlord;
    }

    public void setLanlordTel(String lanlordTel) {
        this.lanlordTel = lanlordTel;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public void setAgentTel(String agentTel) {
        this.agentTel = agentTel;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
