package vn.fis.training.ordermanagement.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fis.training.ordermanagement.dto.OrderDTO;
import vn.fis.training.ordermanagement.model.Order;


import java.util.List;

public interface OrderService {
    Page<OrderDTO> findAll(Pageable pageable);
    Page<OrderDTO> findAllPaidOrders(Pageable pageable);
    OrderDTO findById(Long orderId);
    Order getByid(Long orderId);
    Order createOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrderById(Long orderId);
    List<Order> findAll();
}
