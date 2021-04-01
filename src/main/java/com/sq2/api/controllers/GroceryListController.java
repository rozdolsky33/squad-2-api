package com.sq2.api.controllers;

import com.sq2.api.ententies.Item;
import com.sq2.api.requests.ItemRequestModel;
import com.sq2.api.requests.UpdateItemRequestModel;
import com.sq2.api.service.ItemsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/grocery-items")
public class GroceryListController {

    private ItemsService itemsService;

    @Autowired
    public GroceryListController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addGroceryItem(@RequestBody ItemRequestModel requestModel){
        ModelMapper modelMapper = new ModelMapper();
        Item saveItem = modelMapper.map(requestModel, Item.class);
        Item returnValue = itemsService.saveItem(saveItem);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?>getAllGroceryItems(){
        return new ResponseEntity<>(itemsService.getAllItems(), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>updateItemOnTheList(@RequestParam String id, @RequestBody UpdateItemRequestModel updateItemRequest){

        ModelMapper modelMapper = new ModelMapper();
        Item updateItem = modelMapper.map(updateItemRequest, Item.class);
        Item returnValue = itemsService.updateItemById(Integer.parseInt(id), updateItem);

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItemById(@PathVariable String id){
        itemsService.deleteItemById(Integer.parseInt(id));
    }

}
