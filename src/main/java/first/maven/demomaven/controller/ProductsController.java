package first.maven.demomaven.controller;

import first.maven.demomaven.model.ProductReviews;
import first.maven.demomaven.model.Products;
import first.maven.demomaven.service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/products")
public class ProductsController {
    private final ProductsService productsService;
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }
    // get all products
    @GetMapping("")
    public List<Products> findAll() {
        return productsService.findAll();
    }
    // get products by id
    @GetMapping("/{id}")
    public Products findById(@PathVariable Integer id) {
        return productsService.findById(id);
    }
    // post create product
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Products create(@Valid @RequestBody Products products) {
        return productsService.create(products);
    }
    // delete product
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productsService.delete(id);
    }
}
