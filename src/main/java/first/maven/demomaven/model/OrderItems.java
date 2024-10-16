package first.maven.demomaven.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Orders orders;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Products products;

    public OrderItems() {

    }

    public OrderItems(Integer orderItemId, Orders orders, Products products) {
        this.orderItemId = orderItemId;
        this.orders = orders;
        this.products = products;
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public Orders getOrders() {
        return orders;
    }

    public Products getProducts() {
        return products;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
