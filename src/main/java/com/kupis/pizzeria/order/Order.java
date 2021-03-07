package com.kupis.pizzeria.order;

import com.kupis.pizzeria.pizza.Pizza;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "client_order")
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long orderId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_pizza",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id")
    )
    private Collection<Pizza> pizzas = new ArrayList<>();

    @Column(nullable = false)
    private BigDecimal totalPrice;

    public Order() {
    }

    public Order(Collection<Pizza> pizzas, BigDecimal totalPrice) {
        this.pizzas = pizzas;
        this.totalPrice = totalPrice;
    }

    public Collection<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Collection<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
