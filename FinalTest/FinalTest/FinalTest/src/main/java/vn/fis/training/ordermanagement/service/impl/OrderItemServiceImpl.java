package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.model.OrderItem;
import vn.fis.training.ordermanagement.repository.OrderItemsRepository;
import vn.fis.training.ordermanagement.service.OrderItemService;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Override
    public OrderItem findById(Long id) {
        return orderItemsRepository.findById(id).get();
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemsRepository.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        return orderItemsRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItemById(Long orderItemId) {
        orderItemsRepository.deleteById(orderItemId);
    }

    @Override
    public List<OrderItem> findAll() {
        return orderItemsRepository.findAll();
    }
}
