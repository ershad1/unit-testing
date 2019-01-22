package com.in28minutes.unittesing.unittesting.controller;

import com.in28minutes.unittesing.unittesting.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1, "Ball", 10, 100);
    }
}
