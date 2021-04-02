package com.sq2.api.service;

import com.sq2.api.ententies.ItemEntity;
import com.sq2.api.ententies.ItemsListEntity;
import org.springframework.data.domain.Page;

public interface ItemsListService {

    ItemsListEntity createGroceryList(String name);
    ItemsListEntity findGroceryListById(int id);
    ItemsListEntity addItemToTheGroceryListById(int id, ItemEntity itemEntity);
    void deleteItemFromTheListById(int listId, int itemId);
    Page<ItemsListEntity>findAllItemLists(int pageNumber, int numberOfElementsPerPage);
    ItemsListEntity findListByListName(String listName);
}
