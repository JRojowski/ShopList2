package io.github.JRojowski.ShopList.Repository;

import io.github.JRojowski.ShopList.Model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlMealRepository extends MealRepository, JpaRepository<Meal, Integer> {
}
