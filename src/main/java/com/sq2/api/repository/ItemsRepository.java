package com.sq2.api.repository;

import com.sq2.api.ententies.ItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ItemsRepository extends CrudRepository<ItemEntity, Integer> {

    List<ItemEntity> findAll();
}
