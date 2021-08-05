package io.github.JRojowski.ShopList.Model.projection;

import io.github.JRojowski.ShopList.Model.Meal;

import java.util.Set;
import java.util.stream.Collectors;

public class MealReadModel {
    private int id;
    private String name;
    private String type;
    private Set<MealFoodReadModel> ingredients;


    public MealReadModel(Meal source) {
        id = source.getId();
        name = source.getName();
        type = source.getType();
        ingredients = source.getIngredients().stream()
                        .map(MealFoodReadModel::new)
                        .collect(Collectors.toSet());
    }


    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Set<MealFoodReadModel> getIngredients() {
        return ingredients;
    }

    public void setIngredients(final Set<MealFoodReadModel> ingredients) {
        this.ingredients = ingredients;
    }
}
