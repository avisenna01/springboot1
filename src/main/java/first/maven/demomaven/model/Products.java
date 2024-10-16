package first.maven.demomaven.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productDescription;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categories_id")
    private Categories categories;
    @NotNull
    private Integer price;
    private String productName;

    public Products() {

    }

    public Products(Integer productId, String productDescription, Categories categories, Integer price
    , String productName) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.categories = categories;
        this.price = price;
        this.productName = productName;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Categories getCategories() {
        return categories;
    }

    public Integer getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
