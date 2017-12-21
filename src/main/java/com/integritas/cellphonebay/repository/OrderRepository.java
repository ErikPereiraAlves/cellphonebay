package com.integritas.cellphonebay.repository;

import com.integritas.cellphonebay.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long> {


    List<Order> getOrders();

    Order findOrder(int id);

    void saveOrder(Order obj);

    void deleteOrder(Order obj);
}
