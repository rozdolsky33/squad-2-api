package com.sq2.api.ententies;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

public class ItemsListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String listName;
    @CreationTimestamp
    private Date cratedDated;
    @UpdateTimestamp
    private Date modifiedDate;
    private boolean active;
    private String unit;
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "item_entity_id")
    private List<ItemEntity> itemsList;

    public ItemsListEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String name) {
        this.listName = name;
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

    public void setItemsList(ItemEntity item) {
        this.itemsList.add(item);
    }
    public void removeItemFromTheList(ItemEntity item){
        this.itemsList.remove(item);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
