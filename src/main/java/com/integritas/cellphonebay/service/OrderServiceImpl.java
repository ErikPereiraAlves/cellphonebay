package com.integritas.cellphonebay.service;

import com.integritas.cellphonebay.model.Item;
import com.integritas.cellphonebay.model.Order;
import com.integritas.cellphonebay.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("OrderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderRepository.class);

    @Override
    public Order findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void saveOrder(Order obj) {
        repository.save(obj);
    }

    @Override
    public void updateOrder(Order obj) {
        saveOrder(obj);
    }

    @Override
    public void deleteOrderById(Long id) {
        repository.delete(id);
    }

    @Override
    public List<Order> findAllOrders() {
        return repository.findAll();
    }

    @Override
    public boolean isOrderExist(Order obj) {
        return findById(obj.getOrderId()) != null;
    }

    @Override
    public Order saveAndFlushOrder(){
        Order order = new Order();
        repository.saveAndFlush(order);
        return order;
    }

    @Override
    public Order buildOrder(List <Item> orderItemsList) {

        Order order = new Order();
        orderItemsList.forEach((k)->{
            LOGGER.debug("Item : " + k.toString());
            order.addItem(k);
        });
        return order;
    }

}
