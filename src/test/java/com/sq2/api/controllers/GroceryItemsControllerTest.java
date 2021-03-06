package com.sq2.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sq2.api.ententies.ItemEntity;
import com.sq2.api.requests.ItemRequestModel;
import com.sq2.api.service.ItemsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GroceryItemsController.class)
class GroceryItemsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemsService itemsService;

    private ObjectMapper objectMapper;

    private ModelMapper modelMapper;

    private ItemEntity itemEntity;

    private ItemRequestModel itemRequestModel;

    @Captor
    private ArgumentCaptor<ItemEntity> requestModelArgumentCaptor;

    private String baseUri = "/api/v1/grocery-items";

    @BeforeEach
    void setUp() {
        this.modelMapper = new ModelMapper();
        this.objectMapper = new ObjectMapper();
        this.itemRequestModel = createItem();
        this.itemEntity = modelMapper.map(itemRequestModel, ItemEntity.class);
        itemEntity.setId(1);


    }

    @Test
    void addGroceryItemShouldCreateItemInDbAndReturn201Test() throws Exception {

        when(itemsService.saveItem(requestModelArgumentCaptor.capture())).thenReturn(itemEntity);

        this.mockMvc.perform(post(baseUri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(itemEntity)))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.itemName", is("Hot Dogs")))
                .andExpect(jsonPath("$.quantity", is(33)))
                .andExpect(jsonPath("$.userName", is("Jeff")));
    }

    @Test
    void updateItemOnTheList() throws Exception {
        when(itemsService.updateItemById(eq(1), requestModelArgumentCaptor.capture())).thenReturn(itemEntity);

        this.mockMvc.perform(put(baseUri +"/{id}", 1)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(objectMapper.writeValueAsString(itemRequestModel))).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.itemName", is("Hot Dogs")))
                .andExpect(jsonPath("$.quantity", is(33)))
                .andExpect(jsonPath("$.userName", is("Jeff")));
    }

    @Test
    void deleteItemById() throws Exception {
        this.mockMvc.perform(delete(baseUri + "/{id}", 1)).andExpect(status().isNoContent());
    }

    @Test
    void getAllGroceryItems() throws Exception{
        ItemRequestModel itemRequestModel1 = createItem();
        ItemEntity itemEntity1 = modelMapper.map(itemRequestModel1, ItemEntity.class);
        itemEntity1.setId(11);
        ItemRequestModel itemRequestModel2 = createItem();
        ItemEntity itemEntity2 = modelMapper.map(itemRequestModel2, ItemEntity.class);
        itemEntity2.setId(33);

        List<ItemEntity> myTestList = new ArrayList<>();
        myTestList.add(itemEntity1);
        myTestList.add(itemEntity2);
        when(itemsService.getAllItems()).thenReturn(myTestList);

        this.mockMvc.perform(get(baseUri).header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.size()", is(2)));
    }

    private ItemRequestModel createItem(){

        ItemRequestModel itemRequestModel = new ItemRequestModel();
        itemRequestModel.setUserName("Jeff");
        itemRequestModel.setItemName("Hot Dogs");
        itemRequestModel.setQuantity(33);

        return itemRequestModel;
    }
}