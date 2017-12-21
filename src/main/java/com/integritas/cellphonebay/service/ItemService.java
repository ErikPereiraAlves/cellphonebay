package com.integritas.cellphonebay.service;

import com.integritas.cellphonebay.model.Item;

import java.util.HashMap;
import java.util.List;

public interface ItemService {

    public Item findById(Long id);

    public void saveItem(Item obj);

    public void updateItem(Item obj);

    public void deleteItemById(Long id);

    public List<Item> findAllItems();

    public boolean isItemExist(Item obj);

    public Item saveAndFlushItem();

    public List<Item> buildItems(HashMap<String, String> map);
}
