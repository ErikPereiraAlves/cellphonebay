package com.integritas.cellphonebay.repository;

import com.integritas.cellphonebay.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    Product findByName(String name);

    List<Product> getProducts();

    Product findProduct(int productId);

    void saveProduct(Product product);

    void deleteProduct(Product product);

}
