package vn.fis.training.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.fis.training.ordermanagement.model.OrderItem;

public interface OrderItemsRepository extends JpaRepository<OrderItem,Long> {
}
