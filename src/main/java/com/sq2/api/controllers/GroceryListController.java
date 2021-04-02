package com.sq2.api.controllers;

import com.sq2.api.ententies.ItemEntity;
import com.sq2.api.ententies.ItemsListEntity;
import com.sq2.api.requests.ItemRequestModel;
import com.sq2.api.service.ItemsListService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/grocery-list")
public class GroceryListController {


    private ItemsListService itemsListService;

    @Autowired
    public GroceryListController(ItemsListService itemsListService) {
        this.itemsListService = itemsListService;
    }

    @PostMapping
    public ResponseEntity<?> createGroceryListWithName(@RequestParam String name){
        ItemsListEntity groceryList = itemsListService.createGroceryList(name);
        return new ResponseEntity<>(groceryList, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getGroceryListById(@PathVariable String id){
        ItemsListEntity returnValue = itemsListService.findGroceryListById(Integer.parseInt(id));
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>addItemToTheListById(@PathVariable String id, @RequestBody ItemRequestModel itemRequestModel){

        int listId = Integer.parseInt(id);
        ModelMapper modelMapper = new ModelMapper();
        ItemEntity saveItem = modelMapper.map(itemRequestModel, ItemEntity.class);
        ItemsListEntity returnValue = itemsListService.addItemToTheGroceryListById(listId, saveItem);

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
}
