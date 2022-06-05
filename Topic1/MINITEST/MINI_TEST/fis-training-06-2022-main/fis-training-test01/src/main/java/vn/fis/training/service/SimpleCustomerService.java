package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.exception.CustomerNotFoundException;
import vn.fis.training.exception.DuplicateCustomerException;
import vn.fis.training.exception.InvalidCustomerException;
import vn.fis.training.store.InMemoryCustomerStore;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleCustomerService implements CustomerService{

    private InMemoryCustomerStore customerStore;

//    List<Customer> list = new ArrayList<>();
//    Customer customer = new Customer();
    @Override
    public Customer findById(String id) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface

        if (isNullOrEmpty(id)){
            throw new IllegalArgumentException(String.format("Không tìm thấy ID %s. ", id));
        }
        List<Customer> list = customerStore.findAll();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(id)){
                return list.get(i);
            }
        }
        throw new CustomerNotFoundException(String.format("Không tìm thấy customer với id %s: ", id));
    }

    private boolean isNullOrEmpty(String id) {
        if (id == null)
            return false;
        if (id.trim().length() == 0)
            return false;
        return true;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        validate(customer);
        checkDuplicate(customer);
        return customerStore.insertOrUpdate(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        validate(customer);
        findById(customer.getId());
        customerStore.insertOrUpdate(customer);
        return null;
    }

    private void checkDuplicate(Customer customer){
        if (customerStore.findAll().stream().anyMatch(custom -> custom.getMobile().equals(customer.getMobile()))){
            throw new DuplicateCustomerException(customer, String.format("Số điện thoại đã tồn tại trên hệ thống"));
        }
    }

    private void validate(Customer customer){
        if (isNullOrEmpty(customer.getName())){
            throw new InvalidCustomerException(customer, "Tên không được bỏ trống");
        }
        if (isNullOrEmpty(customer.getMobile())){
            throw new InvalidCustomerException(customer, "Số điện thoại không được bỏ trống");
        }
        if(isNullOrEmpty(customer.getBirthDay().toString())){
            throw new DuplicateCustomerException(customer,"Ngày sinh không được bỏ trống");
        }
        if(isNullOrEmpty(customer.getStatus().toString())){
            throw new DuplicateCustomerException(customer,"trạng thái không được bỏ trống");
        }
    }

    @Override
    public void deleteCustomerById(String id) {
        if (isNullOrEmpty(id)){
            throw new IllegalArgumentException("Không tìm thấy id customer.");
        }
        findById(id);
        customerStore.deleteById(id);
    }

    @Override
    public List<Customer> findAllOrderByNameAsc() {
        List<Customer> rs = customerStore.findAll().stream()
                .sorted(Comparator.comparing(t -> t.getName()))
                .collect(Collectors.toList());
        return rs.size() > 0 ? rs : Collections.emptyList();
    }

    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {
        Comparator<Customer> ordAsc = Comparator.comparing(t -> t.getName());
        List<Customer> rs = customerStore.findAll().stream()
                .sorted(ordAsc)
                .limit(limit)
                .collect(Collectors.toList());
        return rs.size() > 0 ? rs : Collections.emptyList();
    }

    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, String limit) {
        Comparator<Customer> ordAsc = Comparator.comparing(t -> t.getName());
        List<Customer> rs = customerStore.findAll().stream()
                .filter(t -> t.getName().contains(custName))
                .limit(Integer.parseInt(limit))
                .sorted(ordAsc)
                .collect(Collectors.toList());
        return rs.size() > 0 ? rs : Collections.emptyList();
    }

    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return null;
    }

}
