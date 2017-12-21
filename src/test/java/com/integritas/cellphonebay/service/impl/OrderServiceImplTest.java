package com.integritas.cellphonebay.service.impl;


import com.integritas.cellphonebay.model.Order;
import com.integritas.cellphonebay.service.OrderService;
import com.integritas.cellphonebay.util.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceImplTest {


    @Autowired
    OrderService service;


    @Test
    public void getOrders() {

        List<Order> list  = service.findAllOrders();
    }

    @Test
    public void getOrder() {

        Order order  = service.findById(1l);
    }


    @Test
    public void saveOrder() {
        List <Order> list = new ArrayList<>();
        Order order;

        for(int i =0; i <10; i ++){
            order = new Order();
            order.setStatusId(1);
            order.setCreated(Util.getCurrentTS());
            order.setItems(null);
            service.saveOrder(order);
        }



    }

}