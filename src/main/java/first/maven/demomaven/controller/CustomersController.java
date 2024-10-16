package first.maven.demomaven.controller;

import first.maven.demomaven.model.Customers;
import first.maven.demomaven.service.CustomersService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/customers")
public class CustomersController {
    private final CustomersService customersService;
    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }
    // get all
    @GetMapping("")
    public List<Customers> findAll() {
        return customersService.findAll();
    }
    // get by id
    @GetMapping("/{id}")
    public Customers findById(@PathVariable Integer id) {
        return customersService.findById(id);
    }
    // post create customer
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Customers create(@Valid @RequestBody Customers customers) {
        return customersService.create(customers);
    }
    // delete customer
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        customersService.delete(id);
    }

}
