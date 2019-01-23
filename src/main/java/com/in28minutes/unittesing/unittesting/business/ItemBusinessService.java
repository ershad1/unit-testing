package com.in28minutes.unittesing.unittesting.business;

import com.in28minutes.unittesing.unittesting.data.ItemRepository;
import com.in28minutes.unittesing.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems(){
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            item.setValue(value);
        }
        return items;
    }
}
