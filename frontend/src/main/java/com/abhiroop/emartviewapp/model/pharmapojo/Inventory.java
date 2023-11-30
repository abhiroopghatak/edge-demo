package com.abhiroop.emartviewapp.model.pharmapojo;

public class Inventory {

    public double totalValue;
    public int noOfBoxes;

    public String nearestExpiry;

    @Override
    public String toString() {
        return "Inventory [totalValue=" + totalValue + ", noOfBoxes=" + noOfBoxes + ", nearestExpiry=" + nearestExpiry
                + "]";
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public void setNoOfBoxes(int noOfBoxes) {
        this.noOfBoxes = noOfBoxes;
    }

    public void setNearestExpiry(String nearestExpiry) {
        this.nearestExpiry = nearestExpiry;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public int getNoOfBoxes() {
        return noOfBoxes;
    }

    public String getNearestExpiry() {
        return nearestExpiry;
    }

}
