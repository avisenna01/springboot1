package first.maven.demomaven.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoriesId;
    private String categoryDescription;

    public Categories() {

    }

    public Categories(Integer categoriesId, String categoryDescription) {
        this.categoriesId = categoriesId;
        this.categoryDescription = categoryDescription;
    }

    public Integer getCategoriesId() {
        return categoriesId;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoriesId(Integer categoriesId) {
        this.categoriesId = categoriesId;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
