package first.maven.demomaven.repository;

import first.maven.demomaven.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    List<Customers> findByEmail(String email);
    List<Customers> findByPhone(String phone);
}
