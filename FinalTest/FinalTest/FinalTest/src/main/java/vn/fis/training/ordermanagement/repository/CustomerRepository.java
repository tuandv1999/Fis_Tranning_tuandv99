package vn.fis.training.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.fis.training.ordermanagement.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
