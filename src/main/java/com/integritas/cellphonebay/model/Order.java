package com.integritas.cellphonebay.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.CascadeType.ALL;


@Entity
@Table(name="Order")
public class Order implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @Column (name="order_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long orderId;

    @Column (name="created")
    private java.sql.Date created;


    @Column (name = "status_id" ,nullable = false, columnDefinition = "int default 0")
     private int statusId;

    public Order() {

    }

    public Order(Long orderId, Date created, int statusId) {
        this.orderId = orderId;
        this.created = created;
        this.statusId = statusId;
    }
    public Order(Date created, int statusId) {
        this.orderId = orderId;
        this.created = created;
        this.statusId = statusId;
    }

    @OneToMany(cascade=ALL, mappedBy = "order")
    private Collection<Item> items = new ArrayList<Item>();

    public Collection<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public java.sql.Date getCreated() {
        return created;
    }

    public void setCreated(java.sql.Date created) {
        this.created = created;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }


    @Override
    public String toString() {
        return "Order{" +
                "Order Id='" + orderId + '\'' +
                "Order Created='" + created.toString() + '\'' +
                "Order status=" + statusId +
                '}';
    }


}
