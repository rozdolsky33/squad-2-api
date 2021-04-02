package com.sq2.api.repository;

import com.sq2.api.ententies.ItemsListEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemsListRepository extends PagingAndSortingRepository<ItemsListEntity, Integer> {

    ItemsListEntity findItemsListEntityByListName(String name);
}
