package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Order {
    private int orderId;
    private Date orderStime;
    private Integer landlordId;
    private int orderRent;
    private byte orderStatus;
    private int agentId;
    private Date orderEtime;
    private int applyerId;
    private int houseId;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_stime")
    public Date getOrderStime() {
        return orderStime;
    }

    public void setOrderStime(Date orderStime) {
        this.orderStime = orderStime;
    }

    @Basic
    @Column(name = "landlord_id")
    public Integer getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
    }

    @Basic
    @Column(name = "order_rent")
    public int getOrderRent() {
        return orderRent;
    }

    public void setOrderRent(int orderRent) {
        this.orderRent = orderRent;
    }

    @Basic
    @Column(name = "order_status")
    public byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "agent_id")
    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    @Basic
    @Column(name = "order_etime")
    public Date getOrderEtime() {
        return orderEtime;
    }

    public void setOrderEtime(Date orderEtime) {
        this.orderEtime = orderEtime;
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
        Order order = (Order) o;
        return orderId == order.orderId &&
                orderRent == order.orderRent &&
                orderStatus == order.orderStatus &&
                agentId == order.agentId &&
                applyerId == order.applyerId &&
                houseId == order.houseId &&
                Objects.equals(orderStime, order.orderStime) &&
                Objects.equals(landlordId, order.landlordId) &&
                Objects.equals(orderEtime, order.orderEtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderStime, landlordId, orderRent, orderStatus, agentId, orderEtime, applyerId, houseId);
    }
}
