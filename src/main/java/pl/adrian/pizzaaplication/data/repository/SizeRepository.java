package pl.adrian.pizzaaplication.data.repository;

import org.hibernate.engine.jdbc.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size, Integer> {
}
