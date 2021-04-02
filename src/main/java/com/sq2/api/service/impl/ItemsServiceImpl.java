package com.sq2.api.service.impl;

import com.sq2.api.ententies.ItemEntity;
import com.sq2.api.repository.ItemsRepository;
import com.sq2.api.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    ItemsRepository itemsRepository;

    @Autowired
    public ItemsServiceImpl(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @Override
    public List<ItemEntity> getAllItems() {
        return itemsRepository.findAll();
    }

    @Override
    public ItemEntity saveItem(ItemEntity itemEntity) {
        return itemsRepository.save(itemEntity);
    }

    @Override
    public ItemEntity updateItemById(int id, ItemEntity itemEntity) {

        ItemEntity itemEntityToUpdate = itemsRepository.findById(id).get();
        itemEntityToUpdate.setItemName(itemEntity.getItemName());
        itemEntityToUpdate.setQuantity(itemEntity.getQuantity());
        itemEntityToUpdate.setTargetDate(itemEntity.getTargetDate());
        itemEntityToUpdate.setUserName(itemEntity.getUserName());

        return itemsRepository.save(itemEntityToUpdate);
    }

    @Override
    public void deleteItemById(int id) {
        itemsRepository.deleteById(id);
    }
}
