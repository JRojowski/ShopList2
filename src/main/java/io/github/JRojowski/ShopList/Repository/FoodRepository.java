package io.github.JRojowski.ShopList.Repository;

import io.github.JRojowski.ShopList.Model.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FoodRepository {
    Food save(Food entity);

    List<Food> findAll();

    Page<Food> findAll(Pageable pageable);

    Optional<Food> findById(Integer id);

    Food getById(Integer id);

    boolean existsById(Integer id);
}
