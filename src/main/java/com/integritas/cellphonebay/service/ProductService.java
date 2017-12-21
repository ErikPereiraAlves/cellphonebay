package com.integritas.cellphonebay.service;

import com.integritas.cellphonebay.model.Product;

import java.util.List;

public interface ProductService {

    public Product findById(Long id);

    public Product findByName(String name) ;

    public void saveProduct(Product obj);

    public void updateProduct(Product obj);

    public void deleteProductById(Long id);

    public List<Product> findAllProducts();

    public boolean isProductExist(Product obj);
}
