package com.sq2.api.ententies;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

public class ItemsListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Date cratedDated;
    private Date modifiedDate;
    @OneToMany
    private List<ItemEntity> itemsList;

    public ItemsListEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCratedDated() {
        return cratedDated;
    }

    public void setCratedDated(Date cratedDated) {
        this.cratedDated = cratedDated;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<ItemEntity> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemEntity> itemsList) {
        this.itemsList = itemsList;
    }
}
