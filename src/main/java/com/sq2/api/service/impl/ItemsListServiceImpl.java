package com.sq2.api.service.impl;

import com.sq2.api.ententies.ItemsListEntity;
import com.sq2.api.repository.ItemsListRepository;
import com.sq2.api.service.ItemsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsListServiceImpl implements ItemsListService {

    private ItemsListRepository itemsListRepository;

    @Autowired
    public ItemsListServiceImpl(ItemsListRepository itemsListRepository) {
        this.itemsListRepository = itemsListRepository;
    }

    @Override
    public ItemsListEntity createGroceryList(String name) {
        ItemsListEntity newList = new ItemsListEntity();
        newList.setName(name);
        return itemsListRepository.save(newList);
    }

    @Override
    public ItemsListEntity findListByWithId(int id) {
        return itemsListRepository.findById(id).get();
    }
}
