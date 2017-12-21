package com.integritas.cellphonebay.service.impl;

import com.integritas.cellphonebay.service.ItemService;
import com.integritas.cellphonebay.util.Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemServiceImplTest {

    @Autowired
    ItemService itemService ;

    HashMap<String, String> map;

    @Before
    public void Setup() throws Exception {
        map =  Util.jsonToMap("{\"productId\":1,\"quantity\":11}");
    }


    @Test
    public void buildOrderItems() {

        assertThat(itemService.buildItems(map).size(), is(2));
        assertThat(itemService.buildItems(map).get(0).getProduct().getProductId(), is(1));
    }
}