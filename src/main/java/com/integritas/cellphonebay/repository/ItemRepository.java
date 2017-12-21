package com.integritas.cellphonebay.repository;

import com.integritas.cellphonebay.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> getItems();

    Item findItem(int id);

    void saveItem(Item obj);

    void deleteItem(Item obj);
}
