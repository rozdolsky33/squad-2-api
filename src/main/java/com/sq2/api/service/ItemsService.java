package com.sq2.api.service;

import com.sq2.api.ententies.Item;


import java.util.List;

public interface ItemsService {

    List<Item> getAllItems();
    Item saveItem(Item item);
    Item updateItemById(int id, Item item);
    void deleteItemById(int id);


}
