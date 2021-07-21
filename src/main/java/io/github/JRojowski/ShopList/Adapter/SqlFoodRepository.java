package io.github.JRojowski.ShopList.Adapter;

import io.github.JRojowski.ShopList.Model.Food;
import io.github.JRojowski.ShopList.Model.FoodRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlFoodRepository extends FoodRepository, JpaRepository<Food, Integer> {

}
