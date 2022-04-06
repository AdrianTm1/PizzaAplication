package pl.adrian.pizzaaplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adrian.pizzaaplication.data.entity.size.SizeEntity;

public interface SizeRepository extends JpaRepository<SizeEntity, Integer> {
}
