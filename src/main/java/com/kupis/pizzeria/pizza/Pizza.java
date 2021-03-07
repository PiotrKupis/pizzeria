package com.kupis.pizzeria.pizza;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "pizza_name_unique", columnNames = "name")
        }
)
public class Pizza {

    @Id
    @SequenceGenerator(
            name = "pizza_sequence",
            sequenceName = "pizza_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pizza_sequence"
    )
    private Long pizzaId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String ingredients;

    @Column(nullable = false)
    private BigDecimal price;

    public Pizza() {
    }

    public Pizza(Long pizzaId, String name, String ingredients, BigDecimal price) {
        this.pizzaId = pizzaId;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public Pizza(String name, String ingredients, BigDecimal price) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + pizzaId +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", price=" + price +
                '}';
    }
}
