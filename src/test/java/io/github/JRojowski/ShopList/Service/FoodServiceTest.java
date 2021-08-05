package io.github.JRojowski.ShopList.Service;

import io.github.JRojowski.ShopList.Model.Food;
import io.github.JRojowski.ShopList.Model.Meal;
import io.github.JRojowski.ShopList.Repository.FoodRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FoodServiceTest {

    @Test
    @DisplayName("should throw IllegalArgumentException when food with given id does not exist")
    void addMeals_foodWithGivenIdNotExists_throwsIllegalStateException() {
        // given
        var mockFoodRepository = mock(FoodRepository.class);
        when(mockFoodRepository.existsById(anyInt())).thenReturn(false);
        // system under test
        var toTest = new FoodService(mockFoodRepository);
        // when
        var exception = catchThrowable(() -> toTest.addMeals(1, null));
        // then
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("id not found");
    }

    @Test
    @DisplayName("should update the meals list for the given food id")
    void addMeals_setOfMealsIsUpdated() {
        // given
        var mockFoodRepository = mock(FoodRepository.class);
        when(mockFoodRepository.existsById(anyInt())).thenReturn(true);
        // and
        Food food = new Food();
        Meal meal1 = new Meal();
        Meal meal2 = new Meal();
        Meal meal3 = new Meal();
        Set<Meal> mealsToUpdate = Stream.of(meal1, meal2, meal3)
                .collect(Collectors.toSet());
        Set<Meal> mealsAfterUpdate = food.getMeals();
        mealsAfterUpdate.addAll(mealsToUpdate);
        // and
        when(mockFoodRepository.getById(anyInt())).thenReturn(food);
        // system under test
        var toTest = new FoodService(mockFoodRepository);
        // when
        toTest.addMeals(1, mealsToUpdate);
        // then
        assertThat(food.getMeals()).isEqualTo(mealsAfterUpdate);
    }
}
