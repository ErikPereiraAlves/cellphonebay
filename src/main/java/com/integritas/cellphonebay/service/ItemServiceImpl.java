package com.integritas.cellphonebay.service;

import com.integritas.cellphonebay.model.Item;
import com.integritas.cellphonebay.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("ItemService")
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Autowired
    private ProductService productService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Override
    public Item findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void saveItem(Item obj) {
        repository.save(obj);
    }

    @Override
    public void updateItem(Item obj) {
        saveItem(obj);
    }

    @Override
    public void deleteItemById(Long id) {
        repository.delete(id);
    }

    @Override
    public List<Item> findAllItems() {
        return repository.findAll();
    }

    @Override
    public boolean isItemExist(Item obj) {
        return findById(obj.getItemId()) != null;
    }

    @Override
    public Item saveAndFlushItem(){
        Item item = new Item();
        repository.saveAndFlush(item);
        return item;
    }

    @Override
    public List<Item> buildItems(HashMap<String, String> map) {
        List<Item> list = new ArrayList<>();
        map.forEach((k,v)->{
            LOGGER.debug("Product : " + k + " Amount : " + v);
            list.add(new Item(productService.findById(Long.parseLong(k)),1));
        });
        return list;
    }
}
