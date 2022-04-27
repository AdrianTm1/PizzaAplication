package pl.adrian.pizzaaplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adrian.pizzaaplication.data.entity.pizza.PizzaEntity;

public interface OrderSizeRepository extends JpaRepository<PizzaEntity, Integer> {

    void deleteAllByOrderId(Integer orderId);

}
