package com.kupis.pizzeria.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getPizzas() {
        return this.pizzaRepository.findAll();
    }

    public Pizza getStudent(String pizzaName) {
        Optional<Pizza> pizza = pizzaRepository.findPizzaByName(pizzaName);

        if(pizza.isPresent())
            return pizza.get();
        else
            throw new IllegalStateException("Lack of pizza: "+ pizzaName);
    }
}
