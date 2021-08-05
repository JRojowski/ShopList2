package io.github.JRojowski.ShopList.Model.projection;

import io.github.JRojowski.ShopList.Model.Food;
import io.github.JRojowski.ShopList.Model.Meal;

import java.util.Set;

public class MealFoodWriteModel {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    Food toFood(final Meal meal) {
        return new Food(name, meal);
    }
}
