package com.sq2.api.service.impl;

import com.sq2.api.ententies.ItemEntity;
import com.sq2.api.ententies.ItemsListEntity;
import com.sq2.api.repository.ItemsListRepository;
import com.sq2.api.repository.ItemsRepository;
import com.sq2.api.service.ItemsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public class ItemsListServiceImpl implements ItemsListService {

    private ItemsListRepository itemsListRepository;
    private ItemsRepository itemsRepository;

    @Autowired
    public ItemsListServiceImpl(ItemsListRepository itemsListRepository, ItemsRepository itemsRepository) {
        this.itemsListRepository = itemsListRepository;
        this.itemsRepository = itemsRepository;
    }

    @Override
    public ItemsListEntity createGroceryList(String name) {
        ItemsListEntity newList = new ItemsListEntity();
        newList.setListName(name);
        return itemsListRepository.save(newList);
    }

    @Override
    public ItemsListEntity findGroceryListById(int id) {
        return itemsListRepository.findById(id).get();
    }

    @Override
    public ItemsListEntity addItemToTheGroceryListById(int id, ItemEntity itemEntity) {
        ItemsListEntity itemsListEntity = itemsListRepository.findById(id).get();
        itemsListEntity.setItemsList(itemEntity);
        itemsListRepository.save(itemsListEntity);
        return itemsListEntity;
    }

    @Override
    public void deleteItemFromTheListById(int listId, int itemId) {

        if( itemsListRepository.findById(itemId).isPresent()) {
            itemsRepository.deleteById(itemId);
        }
    }
}
