package io.github.JRojowski.ShopList.Service;

import io.github.JRojowski.ShopList.Model.Meal;
import io.github.JRojowski.ShopList.Model.projection.MealReadModel;
import io.github.JRojowski.ShopList.Model.projection.MealWriteModel;
import io.github.JRojowski.ShopList.Repository.FoodRepository;
import io.github.JRojowski.ShopList.Repository.MealRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MealService {
    private MealRepository repository;
    private FoodRepository foodRepository;

    MealService(final MealRepository repository, final FoodRepository foodRepository) {
        this.repository = repository;
        this.foodRepository = foodRepository;
    }

    public MealReadModel createMeal(final MealWriteModel source) {
        Meal result = repository.save(source.toMeal());
        return new MealReadModel(result);
    }

    public List<MealReadModel> readAll() {
        return repository.findAll().stream()
                .map(MealReadModel::new)
                .collect(Collectors.toList());
    }
}
