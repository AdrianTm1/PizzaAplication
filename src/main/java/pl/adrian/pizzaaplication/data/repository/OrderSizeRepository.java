package pl.adrian.pizzaaplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adrian.pizzaaplication.data.entity.ordersize.OrderSizeEntity;

public interface OrderSizeRepository extends JpaRepository<OrderSizeEntity, Integer> {

    void deleteAllByOrderId(Integer orderId);

}
