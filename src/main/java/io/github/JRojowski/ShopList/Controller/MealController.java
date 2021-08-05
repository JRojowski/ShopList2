package io.github.JRojowski.ShopList.Controller;

import io.github.JRojowski.ShopList.Model.Food;
import io.github.JRojowski.ShopList.Model.Meal;
import io.github.JRojowski.ShopList.Repository.FoodRepository;
import io.github.JRojowski.ShopList.Repository.MealRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class MealController {
    private static final Logger logger = LoggerFactory.getLogger(FoodController.class);
    private final MealRepository repository;

    MealController(final MealRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/meals")
    ResponseEntity<Meal> createMeal(@RequestBody Meal toCreate) {
        Meal result = repository.save(toCreate);
        logger.info("Meal created successfully");
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/meals")
    ResponseEntity<List<Meal>> readAllMeals(Pageable page) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

    @GetMapping(value = "/meals", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Meal>> readAllMeals() {
        logger.warn("Exposing all the meals");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/meals/{id}")
    ResponseEntity<Meal> readMeal(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/meals/{id}")
    ResponseEntity<?> updateMeal(@PathVariable int id, @RequestBody @Valid Meal toUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(meal -> {
                    meal.updateFrom(toUpdate);
                    repository.save(meal);
                });
        return ResponseEntity.noContent().build();
    }
}
