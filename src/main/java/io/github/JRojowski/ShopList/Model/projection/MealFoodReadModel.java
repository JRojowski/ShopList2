package io.github.JRojowski.ShopList.Model.projection;

import io.github.JRojowski.ShopList.Model.Food;

public class MealFoodReadModel {
    private String name;
    private boolean inFridge;


    public MealFoodReadModel(Food source) {
        name = source.getName();
        inFridge = source.isInFridge();
    }


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean isInFridge() {
        return inFridge;
    }

    public void setInFridge(final boolean inFridge) {
        this.inFridge = inFridge;
    }
}
