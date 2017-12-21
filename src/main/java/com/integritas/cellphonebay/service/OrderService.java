package com.integritas.cellphonebay.service;

import com.integritas.cellphonebay.model.Item;
import com.integritas.cellphonebay.model.Order;

import java.util.List;

public interface OrderService {

     Order findById(Long id);

     void saveOrder(Order obj);

     void updateOrder(Order obj);

     void deleteOrderById(Long id);

     List<Order> findAllOrders();

     boolean isOrderExist(Order obj);

     Order saveAndFlushOrder();

     Order buildOrder(List <Item> orderItemsList);
}
