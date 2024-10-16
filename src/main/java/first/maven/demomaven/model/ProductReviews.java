package first.maven.demomaven.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_reviews")
public class ProductReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productReviewsId;
    private String review;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Products products;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customers customers;
    private Integer rating;

    public ProductReviews() {

    }

    public ProductReviews(Integer productReviewsId, String review
    , Products products, Customers customers, Integer rating) {
        this.productReviewsId = productReviewsId;
        this.review = review;
        this.products = products;
        this.customers = customers;
        this.rating = rating;
    }

    public Integer getProductReviewsId() {
        return productReviewsId;
    }

    public String getReview() {
        return review;
    }

    public Products getProducts() {
        return products;
    }

    public Customers getCustomers() {
        return customers;
    }

    public Integer getRating() {
        return rating;
    }

    public void setProductReviewsId(Integer productReviewsId) {
        this.productReviewsId = productReviewsId;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
