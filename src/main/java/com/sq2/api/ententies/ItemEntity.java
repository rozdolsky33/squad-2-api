package com.sq2.api.ententies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String itemName;
    private Date cratedDated;
    private Date modifiedDat;
    private String unit;
    private int quantity;


    public ItemEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
