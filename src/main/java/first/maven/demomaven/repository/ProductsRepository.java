package first.maven.demomaven.repository;

import first.maven.demomaven.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products,Integer> {

    List<Products> findAllByProductName(String productName);
    List<Products> findAllByProductDescription(String productDescription);
}
