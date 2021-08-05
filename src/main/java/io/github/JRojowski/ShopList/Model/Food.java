package io.github.JRojowski.ShopList.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    private String name;
    private String firm;
    private String category;
    private float price;
    private boolean inFridge;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ingredients")
    private Set<Meal> meals = new HashSet<>();


    public Food() {
    }

    public Food(final String name, final Meal meal) {
        this.name = name;
        Set<Meal> meals = new HashSet<>();
        meals.add(meal);
        this.meals = meals;
    }

    public Food(final String name, final String firm, final String category, final float price, final Set<Meal> meals) {
        this.name = name;
        this.firm = firm;
        this.category = category;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    public String getFirm() {
        return firm;
    }

    void setFirm(final String firm) {
        this.firm = firm;
    }

    public String getCategory() {
        return category;
    }

    void setCategory(final String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    void setPrice(final float price) {
        this.price = price;
    }

    public boolean isInFridge() {
        return inFridge;
    }

    public void setInFridge(final boolean inFridge) {
        this.inFridge = inFridge;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(final Set<Meal> meals) {
        this.meals = meals;
    }

    public void updateFrom(final Food source) {
        name = source.name;
        firm = source.firm;
        category = source.category;
        price = source.price;
    }
}
