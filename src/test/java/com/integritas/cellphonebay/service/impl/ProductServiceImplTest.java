package com.integritas.cellphonebay.service.impl;

import com.integritas.cellphonebay.model.Product;
import com.integritas.cellphonebay.service.ProductService;
import com.integritas.cellphonebay.util.Util;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImplTest.class);

    Product product;

    Long id = -1l;

    @Before
    public void createProduct() {
        product = new Product();
        product.setProductDesc("junit test case");
        product.setProductPrice(11.50);
        product.setProductAvailable(1000);
        product.setProductName("Iphone 6");
        product.setCreated(Util.getCurrentTS());
        productService.saveProduct(product);
        LOGGER.debug("created new product with id {}",product.getProductId());
        id = product.getProductId();
    }

    @Test
    public void getProducts() {
        List<Product> products = productService.findAllProducts();

        // Assert.assertEquals(products.size(),0);
        assertThat(products.size() > 0, is(true));
    }

    @Test
    public void findProduct() {

        Product product = productService.findById(id);
        Assert.assertEquals(product.getProductId(), id);
    }
}