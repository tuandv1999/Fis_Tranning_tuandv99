package vn.fis.training.ordermanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import vn.fis.training.ordermanagement.model.Customer;
import vn.fis.training.ordermanagement.repository.CustomerRepository;
import vn.fis.training.ordermanagement.service.CustomerService;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/")
    public Page<Customer>findAll(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy
            ){
        return customerRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        5,
                        Sort.Direction.ASC,sortBy.orElse("id")
                )
        );
    }
    @GetMapping("/{customerId}")
    public Customer findById(@PathVariable Long customerId){
        return customerService.findById(customerId);
    }
    @PutMapping("/create")
    public Customer Create(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
    @PostMapping("/update/{customerId}")
    public Customer Update(@PathVariable Long customerId,Customer customer){
        Customer customer1=customerService.findById(customerId);
        if(customer1!=null){
            customer1.setId(customer.getId());
            customer1.setName(customer.getName());
            customer1.setAddress(customer.getAddress());
            customer1.setMobile(customer.getMobile());
        }

        return customerService.createCustomer(customer1);
    }
    @PostMapping("delete/{customerId}")
    public void Delete(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
    }

}
