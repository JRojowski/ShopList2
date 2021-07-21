package io.github.JRojowski.ShopList.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    private String name;
    private String firm;
    private String description;
    private String category;
    private float price;

    public Food() {
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

    public float getPrice() {
        return price;
    }

    void setPrice(final float price) {
        this.price = price;
    }

    public void updateFrom(final Food source) {
        name = source.name;
        firm = source.firm;
        description = source.description;
        category = source.category;
        price = source.price;
    }
}
