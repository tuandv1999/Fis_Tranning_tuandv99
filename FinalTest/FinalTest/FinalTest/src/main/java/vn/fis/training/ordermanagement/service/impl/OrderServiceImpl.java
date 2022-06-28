package vn.fis.training.ordermanagement.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.dto.OrderDTO;
import vn.fis.training.ordermanagement.model.Order;
import vn.fis.training.ordermanagement.model.OrderStatus;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.OrderService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public Page<OrderDTO> findAll(Pageable pageable) {
        log.info("Query all Order. PageNumber: {}, PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
        return orderRepository.findAll(pageable).map(OrderDTO.Mapper::fromEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<OrderDTO> findAllPaidOrders(Pageable pageable) {
        return orderRepository.findAllByStatus(OrderStatus.PAID, pageable).map(OrderDTO.Mapper::fromEntity);
    }

    @Override
    public OrderDTO findById(Long orderId) {
        return OrderDTO.Mapper.fromEntity(orderRepository.findById(orderId).orElseThrow(
                () -> {throw new IllegalArgumentException(String.format("Not found order with id %s",orderId));}));
    }

    @Override
    public Order getByid(Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }




}
