package com.sq2.api.service;

import com.sq2.api.ententies.ItemEntity;
import com.sq2.api.ententies.ItemsListEntity;

public interface ItemsListService {

    ItemsListEntity createGroceryList(String name);
    ItemsListEntity findGroceryListById(int id);
    ItemsListEntity addItemToTheGroceryListById(int id, ItemEntity itemEntity);
    void deleteItemFromTheListById(int listId, int itemId);
}
