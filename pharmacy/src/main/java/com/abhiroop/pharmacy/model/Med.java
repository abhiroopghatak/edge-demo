package com.abhiroop.pharmacy.model;

import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Med {
    
    public String name;
    public String category;
    public double unitPrice;
    public Date expiryDate;
    public String batchNo;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getBatchNo() {
        return batchNo;
    }
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
    public Med(String name, String category, double unitPrice, Date expiryDate, String batchNo) {
        this.name = name;
        this.category = category;
        this.unitPrice = unitPrice;
        this.expiryDate = expiryDate;
        this.batchNo = batchNo;
    }
    @Override
    public String toString() {
        return "Med [name=" + name + ", category=" + category + ", unitPrice=" + unitPrice + ", expiryDate="
                + expiryDate + ", batchNo=" + batchNo + "]";
    }
    
}


