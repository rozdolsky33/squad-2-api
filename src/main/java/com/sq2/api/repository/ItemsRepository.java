package com.sq2.api.repository;

import com.sq2.api.ententies.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ItemsRepository extends CrudRepository<Item, Integer> {

    List<Item> findAll();
}
