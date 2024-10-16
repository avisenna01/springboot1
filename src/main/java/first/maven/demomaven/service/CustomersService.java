package first.maven.demomaven.service;

import first.maven.demomaven.event.EventNotFoundException;
import first.maven.demomaven.model.Customers;
import first.maven.demomaven.repository.CustomersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {
    private final CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }
    // get all customers
    public List<Customers> findAll() {
        return customersRepository.findAll();
    }
    // get customers by id
    public Customers findById(Integer id) {
        return customersRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException());
    }
    // POST
    public Customers create(Customers customers) {
        return customersRepository.save(customers);
    }
    // DELETE
    public void delete(Integer id) {
        customersRepository.delete(customersRepository
                .findById(id)
                .orElseThrow(() -> new EventNotFoundException()));
    }

}
