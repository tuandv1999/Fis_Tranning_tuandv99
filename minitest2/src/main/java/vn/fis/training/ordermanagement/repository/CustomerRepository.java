package vn.fis.training.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fis.training.ordermanagement.domain.Customer;

@Repository
public interface  CustomerRepository extends JpaRepository<Customer, Long> {
    Customer getById(Long id);
    Customer getByMobile(String mobile);
}
