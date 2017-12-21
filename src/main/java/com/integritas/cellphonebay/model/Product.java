package com.integritas.cellphonebay.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name="Product")
public class Product implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @Column (name = "product_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long productId;

    @Column (name = "product_name")
    private String productName;

    @Column (name = "product_desc")
    private String productDesc;

    @Column (name = "product_price")
    private Double productPrice;

    @Column (name = "created")
    private java.sql.Date created;

    @Column (name = "available")
    private int productAvailable;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public java.sql.Date getCreated() {
        return created;
    }


    public int getProductAvailable() {
        return productAvailable;
    }

    public void setProductAvailable(int productAvailable) {
        this.productAvailable = productAvailable;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Product id='" + productId + '\'' +
                "Product desc='" + productDesc + '\'' +
                "Product price='" + productPrice + '\'' +
                "Product created TS='" + created + '\'' +
                "Product availability='" + productAvailable +
                '}';
    }
}
