package personal.nutrisport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.nutrisport.fatsecret.model.Food;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> getFoodsByName(String name);
    String create(Food food);
}
