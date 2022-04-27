package pl.adrian.pizzaaplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adrian.pizzaaplication.data.entity.order.OrderEntity;
import pl.adrian.pizzaaplication.data.entity.pizza.PizzaEntity;

import java.util.List;

public interface OrderRepository extends JpaRepository<PizzaEntity, Integer> {

    OrderEntity findByToken(String token);

    List<OrderEntity> findAllByStatus(String status);

}
