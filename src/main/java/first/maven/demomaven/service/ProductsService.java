package first.maven.demomaven.service;

import first.maven.demomaven.event.EventNotFoundException;
import first.maven.demomaven.model.Products;
import first.maven.demomaven.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    // get all products
    public List<Products> findAll() {
        return productsRepository.findAll();
    }
    // get product by id
    public Products findById(Integer id) {
        return productsRepository
                .findById(id)
                .orElseThrow(() -> new EventNotFoundException());
    }
    // POST
    public Products create(Products products){
        return productsRepository.save(products);
    }
    // DELETE
    public void delete(Integer id) {
        productsRepository.delete(productsRepository
                .findById(id)
                .orElseThrow(() -> new EventNotFoundException()));
    }

}
