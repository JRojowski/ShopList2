package io.github.JRojowski.ShopList.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    private String name;
    private String type;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "meals_foods",
            joinColumns = {@JoinColumn(name = "meal_id")},
            inverseJoinColumns = {@JoinColumn(name = "food_id")})
    private Set<Food> ingredients = new HashSet<>();


    public Meal() {
    }

    public Meal(final String name, final String type, final Set<Food> ingredients) {
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
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

    public void setName(final String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Set<Food> getIngredients() {
        return ingredients;
    }

    public void setIngredients(final Set<Food> ingredients) {
        this.ingredients = ingredients;
    }

    public void updateFrom(final Meal source) {
        name = source.name;
        type = source.type;
        ingredients = source.ingredients;
    }
}





