package com.sq2.api.requests;

import com.sq2.api.ententies.Items;

import java.util.List;

public class UpdateUserListModel {

    private List<Items> groceryItems;

    public List<Items> getGroceryItems() {
        return groceryItems;
    }

    public void setGroceryItems(List<Items> groceryItems) {
        this.groceryItems = groceryItems;
    }
}
