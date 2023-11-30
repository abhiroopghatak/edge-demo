package com.abhiroop.pharmacy.model;

import java.util.List;

public class OrderDue {
    
    public String orderId;
    public String duedate;
    public double orderPrice;
    public String orderDate;
    public List<Med> meds;
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getDuedate() {
        return duedate;
    }
    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }
    public double getOrderPrice() {
        return orderPrice;
    }
    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public List<Med> getMeds() {
        return meds;
    }
    public void setMeds(List<Med> meds) {
        this.meds = meds;
    }
    public OrderDue(String orderId, String duedate, double orderPrice, String orderDate, List<Med> meds) {
        this.orderId = orderId;
        this.duedate = duedate;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
        this.meds = meds;
    }
    @Override
    public String toString() {
        return "OrderDue [orderId=" + orderId + ", duedate=" + duedate + ", orderPrice=" + orderPrice + ", orderDate="
                + orderDate + ", meds=" + meds + "]";
    }

    
}
