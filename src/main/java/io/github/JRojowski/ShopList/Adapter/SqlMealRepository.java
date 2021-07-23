package io.github.JRojowski.ShopList.Adapter;

import io.github.JRojowski.ShopList.Model.Food;
import io.github.JRojowski.ShopList.Model.FoodRepository;
import io.github.JRojowski.ShopList.Model.Meal;
import io.github.JRojowski.ShopList.Model.MealRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlMealRepository extends MealRepository, JpaRepository<Meal, Integer> {
}
