package com.integritas.cellphonebay.service;

import com.integritas.cellphonebay.model.Product;
import com.integritas.cellphonebay.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ProductService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public Product findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Product findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void saveProduct(Product obj) {
        repository.save(obj);
    }

    @Override
    public void updateProduct(Product obj) {
        saveProduct(obj);
    }

    @Override
    public void deleteProductById(Long id) {
        repository.delete(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    public boolean isProductExist(Product obj) {
        return findByName(obj.getProductName()) != null;
    }
}
