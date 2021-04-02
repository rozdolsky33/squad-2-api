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

    @GetMapping("/{list-id}")
    public ResponseEntity<?>getGroceryListById(@PathVariable("list-id") int listId){
        ItemsListEntity returnValue = itemsListService.findGroceryListById(listId);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
    @PutMapping("/{list-id}")
    public ResponseEntity<?>addItemToTheListById(@PathVariable("list-id") int listId, @RequestBody ItemRequestModel itemRequestModel){

        ModelMapper modelMapper = new ModelMapper();
        ItemEntity saveItem = modelMapper.map(itemRequestModel, ItemEntity.class);
        ItemsListEntity returnValue = itemsListService.addItemToTheGroceryListById(listId, saveItem);

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
    @DeleteMapping("/{list-id}/item/{item-id}")
    public ResponseEntity<?>deleteItemFromTheList(@PathVariable("list-id") int listId, @PathVariable("item-id") int itemId){
        itemsListService.deleteItemFromTheListById(listId, itemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?>getAllGroceryLists(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber, @RequestParam(value = "numberOfElementsPerPage", defaultValue = "10") int numberOfElementsPerPage){
        return new ResponseEntity<>(itemsListService.findAllItemLists(pageNumber, numberOfElementsPerPage), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<?>getListByListName(@RequestParam String name){
        return new ResponseEntity<>(itemsListService.findListByListName(name), HttpStatus.OK);
    }

}
