package io.github.JRojowski.ShopList.Model.projection;

import io.github.JRojowski.ShopList.Model.Meal;

import java.util.Set;
import java.util.stream.Collectors;

public class MealWriteModel {
    private String name;
    private String type;
    private Set<MealFoodWriteModel> ingredients;


    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    String getType() {
        return type;
    }

    void setType(final String type) {
        this.type = type;
    }

    Set<MealFoodWriteModel> getIngredients() {
        return ingredients;
    }

    void setIngredients(final Set<MealFoodWriteModel> ingredients) {
        this.ingredients = ingredients;
    }

    //TUTAJ NA PEWNO NIE DZIAŁA DODAWANIE KOLEJNYCH MEALSOW, TRZEBA POGRZEBAĆ W KONSTRUKTORACH FOOD
    public Meal toMeal() {
        var result = new Meal();
        result.setName(name);
        result.setType(type);
        result.setIngredients(
                ingredients.stream()
                    .map(food -> food.toFood(result))
                    .collect(Collectors.toSet())
        );
        return result;
    }
}
