package et.com.amanuwel.repository;

import et.com.amanuwel.Entity.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderFoodRepository extends JpaRepository<OrderFood, Long> {
}
