package vn.fis.training.ordermanagement.service;

import vn.fis.training.ordermanagement.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomerById(Long customerId);
    List<Customer> findAll();
}
