package io.github.JRojowski.ShopList.Controller;

import io.github.JRojowski.ShopList.Model.Food;
import io.github.JRojowski.ShopList.Model.FoodRepository;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.net.URI;
import java.util.List;


@RestController
class FoodController {
    private static final Logger logger = LoggerFactory.getLogger(FoodController.class);
    private final FoodRepository repository;

    FoodController(final FoodRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/foods")
    ResponseEntity<Food> createFood(@RequestBody Food toCreate) {
        Food result = repository.save(toCreate);
        logger.info("Food created successfully");
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/foods")
    ResponseEntity<List<Food>> readAllFoods(Pageable page) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

    @GetMapping(value = "/foods", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Food>> readAllFoods() {
        logger.warn("Exposing all the foods");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/foods/{id}")
    ResponseEntity<Food> readFood(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/foods/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Valid Food toUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(food -> {
                    food.updateFrom(toUpdate);
                    repository.save(food);
                });
        return ResponseEntity.noContent().build();
    }
}