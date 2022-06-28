package vn.fis.training.ordermanagement.service;

import vn.fis.training.ordermanagement.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem findById(Long id);
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItem updateOrderItem(OrderItem orderItem);
    void deleteOrderItemById(Long orderItemId);
    List<OrderItem> findAll();
}
