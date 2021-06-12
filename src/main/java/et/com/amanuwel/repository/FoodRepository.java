package et.com.amanuwel.repository;

import et.com.amanuwel.Entity.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {
    @Transactional
    @Modifying
    @Query("from  Food u where u.itemName = :food_name order by u.id")
    List<Food> searchFoodByFoodName(@Param("food_name") String food_name);
}
