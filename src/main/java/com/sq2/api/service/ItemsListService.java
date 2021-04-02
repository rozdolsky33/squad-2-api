package com.sq2.api.service;

import com.sq2.api.ententies.ItemsListEntity;

public interface ItemsListService {

    ItemsListEntity createGroceryList(String name);
    ItemsListEntity findListByWithId(int id);
}
