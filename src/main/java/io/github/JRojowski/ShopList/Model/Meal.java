package io.github.JRojowski.ShopList.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    private String name;
    private String description;
    private String category;
    @ManyToMany
    @JoinTable(
            name = "meals_food",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private Set<Meal> ingredients = new HashSet<>();

    public Meal() {
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

    public String getDescription() {
        return description;
    }

    void setDescription(final String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    void setCategory(final String category) {
        this.category = category;
    }

    Set<Meal> getIngredients() {
        return ingredients;
    }

    void setIngredients(final Set<Meal> ingredients) {
        this.ingredients = ingredients;
    }

    public void updateFrom(final Meal source) {
        name = source.name;
        description = source.description;
        category = source.category;
    }
}
