package vn.fis.training.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fis.training.ordermanagement.domain.OrderItem;
@Repository
public interface OderItemRespository extends JpaRepository<OrderItem,Long> {
}
