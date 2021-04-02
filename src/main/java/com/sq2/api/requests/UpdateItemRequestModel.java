package com.sq2.api.requests;


import java.util.Date;

public class UpdateItemRequestModel {

    private String userName;
    private String itemName;
    private Date cratedDated;
    private Date modifiedDat;
    private int quantity;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCratedDated() {
        return cratedDated;
    }

    public void setCratedDated(Date cratedDated) {
        this.cratedDated = cratedDated;
    }

    public Date getModifiedDat() {
        return modifiedDat;
    }

    public void setModifiedDat(Date modifiedDat) {
        this.modifiedDat = modifiedDat;
    }
}
