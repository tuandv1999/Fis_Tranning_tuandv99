package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.repository.CustomerRepository;
import vn.fis.training.ordermanagement.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        Customer customer = customerRepository.getById(customerId);
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer>list=customerRepository.findAll();
        return list;
    }

    @Override
    public Customer findByMobileNumber(String mobileNumber) {
        Customer customer = customerRepository.getByMobile(mobileNumber);
        return customer;
    }
}
