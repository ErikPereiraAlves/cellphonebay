package com.integritas.cellphonebay.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="Item")
public class Item  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column (name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, //
            foreignKey = @ForeignKey(name = "item_order_id_fk") )
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, //
            foreignKey = @ForeignKey(name = "item_product_id_fk") )
    private Product product;

    @Column (name = "quantity")
    private int quantity;

    public Item() {

    }

    public Item(Long itemId, Product product, int quantity) {
        this.itemId = itemId;
        this.product = product;
        this.quantity = quantity;
    }


    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order Item{" +
                "Item id='" + itemId + '\'' +
                "Order id='" + order.getOrderId() + '\'' +
               // "Product='" + product.stream().collect(Collectors.toList()).toString() + '\'' +
                "Product='" + product.getProductId() + '\'' +
                "Quantity='" + quantity +

                '}';
    }
}
