package io.github.JRojowski.ShopList.Repository;

import io.github.JRojowski.ShopList.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlFoodRepository extends FoodRepository, JpaRepository<Food, Integer> {

}
