package com.in28minutes.unittesing.unittesting.controller;

import com.in28minutes.unittesing.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesing.unittesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;
    @Test
    public void dummyItem_basic() throws Exception {
        // call "/dummy-item" application/json


        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

//        JSONAssert.assertEquals(content, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception {
        // call "/dummy-item" application/json

        when(itemBusinessService.retrieveHardcodedItem()).thenReturn(
                new Item(2, "item2", 10, 10)
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2,name:item2,price:10,quantity:10}"))
                .andReturn();

        //        JSONAssert.assertEquals(content, result.getResponse().getContentAsString(), false);
    }
}