package io.github.JRojowski.ShopList.Repository;

import io.github.JRojowski.ShopList.Model.Meal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MealRepository {
    Meal save(Meal entity);

    List<Meal> findAll();

    Page<Meal> findAll(Pageable pageable);

    Optional<Meal> findById(Integer id);

    boolean existsById(Integer id);
}
