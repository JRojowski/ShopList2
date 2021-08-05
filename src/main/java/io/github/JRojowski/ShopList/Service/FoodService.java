package io.github.JRojowski.ShopList.Service;

import io.github.JRojowski.ShopList.Model.Food;
import io.github.JRojowski.ShopList.Model.Meal;
import io.github.JRojowski.ShopList.Repository.FoodRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FoodService {
    @Autowired
    FoodRepository repo;


    FoodService(final FoodRepository repo) {
        this.repo = repo;
    }


    public void addMeals(int id, Set<Meal> meals) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Food with given id not found");
        }
        Food foodToUpdate = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Food with given id not found"));
        Set<Meal> setToUpdate = foodToUpdate.getMeals();
        setToUpdate.addAll(meals);
        foodToUpdate.setMeals(setToUpdate);
        repo.save(foodToUpdate);
    }

    public void toggleFridge(int id) {
        Food foodToUpdate = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Food with given id not found"));
        foodToUpdate.setInFridge(!foodToUpdate.isInFridge());
        repo.save(foodToUpdate);
    }
}
