package com.in28minutes.unittesing.unittesting.controller;

import com.in28minutes.unittesing.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesing.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1, "Ball", 10, 100);
    }


    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        return itemBusinessService.retrieveHardcodedItem();
    }



}
