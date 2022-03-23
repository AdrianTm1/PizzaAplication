package pl.adrian.pizzaaplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adrian.pizzaaplication.data.entity.pizza.PizzaEntity;

public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer> {
}
