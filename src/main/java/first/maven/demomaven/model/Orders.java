package first.maven.demomaven.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Date orderDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customers customers;

    public Orders() {

    }

    public Orders(Integer orderId, Date orderDate, Customers customers){
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customers = customers;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
}
