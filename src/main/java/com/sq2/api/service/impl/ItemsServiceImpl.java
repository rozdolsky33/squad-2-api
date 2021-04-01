package com.sq2.api.service.impl;

import com.sq2.api.ententies.Item;
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
    public List<Item> getAllItems() {
        return itemsRepository.findAll();
    }

    @Override
    public Item saveItem(Item item) {
        return itemsRepository.save(item);
    }

    @Override
    public Item updateItemById(int id, Item item) {

        Item itemToUpdate = itemsRepository.findById(id).get();
        itemToUpdate.setItemName(item.getItemName());
        itemToUpdate.setQuantity(item.getQuantity());
        itemToUpdate.setTargetDate(item.getTargetDate());
        itemToUpdate.setUserName(item.getUserName());

        return itemsRepository.save(itemToUpdate);
    }

    @Override
    public void deleteItemById(int id) {
        itemsRepository.deleteById(id);
    }
}
