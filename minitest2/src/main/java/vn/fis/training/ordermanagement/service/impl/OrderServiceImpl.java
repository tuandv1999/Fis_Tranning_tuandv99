package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.Order;
import vn.fis.training.ordermanagement.domain.OrderItem;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order createOrder(Order order) {

        return orderRepository.save(order);
    }

    @Override
    public Order addOrderItem(Long orderId,OrderItem orderItem) {

        return null;
    }

    @Override
    public Order removeOrderItem(Long orderId,OrderItem orderItem) {
        return null;
    }

    @Override
    public Order updateOrderStatus(Order order,OrderStatus orderStatus) {
        return null;
    }

    @Override
    public List<Order> findOrdersBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        List<Order>list=orderRepository.findByStartDateBetween(fromDateTime,toDateTime);
        return list;
    }

    @Override
    public List<Order> findWaitingApprovalOrders() {
        List<Order>list=orderRepository.findAll();
        List<Order>list1=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getStatus().equals("WAITING_APPROVAL")){
                list1.add(list.get(i));
            }

        }
        return list1;
    }

    @Override
    public List<Order> findOrdersByOrderStatus(OrderStatus orderStatus) {
        List<Order>list=orderRepository.findAll();
        List<Order>list1=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getStatus().equals(orderStatus)){
                    list1.add(list.get(i));
            }

        }
        return list1;
    }

    @Override
    public List<Order> findOrdersByCustomer(Customer customer) {
        List<Order>list=orderRepository.findAll();
        List<Order>list1=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCustomer().equals(customer.getId())){
                list1.add(list.get(i));
            }
        }
        return list1;
//        return orderRepository.findAll().stream().filter(t->t.getId().equals(customer.getId())).collect(Collectors.toList());
    }
}
