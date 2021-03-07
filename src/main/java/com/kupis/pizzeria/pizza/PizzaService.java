package com.kupis.pizzeria.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
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

    public Pizza getPizzaById(Long pizzaId) {

        Optional<Pizza> pizza = pizzaRepository.findById(pizzaId);

        if (pizza.isPresent())
            return pizza.get();
        else
            throw new IllegalStateException("Lack of pizza with " + pizzaId + " id");
    }

    public Pizza getPizzaByName(String pizzaName) {

        Optional<Pizza> pizza = pizzaRepository.findByName(pizzaName);

        if (pizza.isPresent())
            return pizza.get();
        else
            throw new IllegalStateException("Lack of pizza: " + pizzaName);
    }

    public void addPizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    public void deletePizzaById(Long pizzaId) {

        Optional<Pizza> pizza = pizzaRepository.findById(pizzaId);

        if (pizza.isPresent())
            pizzaRepository.deleteById(pizzaId);
        else
            throw new IllegalStateException("Lack of pizza with " + pizzaId + " id");
    }

    public void deletePizzaByName(String pizzaName) {

        Optional<Pizza> pizza = pizzaRepository.findByName(pizzaName);

        if (pizza.isPresent())
            pizzaRepository.delete(pizza.get());
        else
            throw new IllegalStateException("Lack of pizza called " + pizzaName);
    }

    @Transactional
    public void updatePizza(Long pizzaId, Pizza updatedPizza) {

        Optional<Pizza> pizza = pizzaRepository.findById(pizzaId);

        if (pizza.isPresent()) {
            if (updatedPizza.getName().length() > 0 && updatedPizza.getIngredients().length() > 0 && updatedPizza.getPrice().compareTo(BigDecimal.ZERO) > 0) {
                pizza.get().setName(updatedPizza.getName());
                pizza.get().setIngredients(updatedPizza.getIngredients());
                pizza.get().setPrice(updatedPizza.getPrice());
            }
        } else
            throw new IllegalStateException("Lack of pizza with " + pizzaId + " id");
    }
}
