package first.maven.demomaven.model;

import jakarta.persistence.*;

public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private String paymentType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Orders orders;

    public PaymentDetails() {

    }

    public PaymentDetails(Integer paymentId, String paymentType
    , Orders orders) {
        this.paymentId = paymentId;
        this.paymentType = paymentType;
        this.orders = orders;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
