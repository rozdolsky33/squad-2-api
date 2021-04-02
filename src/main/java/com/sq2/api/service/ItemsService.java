package com.sq2.api.service;

import com.sq2.api.ententies.ItemEntity;


import java.util.List;

public interface ItemsService {

    List<ItemEntity> getAllItems();
    ItemEntity saveItem(ItemEntity itemEntity);
    ItemEntity updateItemById(int id, ItemEntity itemEntity);
    void deleteItemById(int id);


}
