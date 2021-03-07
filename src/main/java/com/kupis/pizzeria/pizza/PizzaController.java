package com.kupis.pizzeria.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("pizzas")
    public List<Pizza> getPizzas() {
        return pizzaService.getPizzas();
    }

    @GetMapping("pizza/{pizzaId}")
    public Pizza getPizzaById(@PathVariable Long pizzaId) {
        return pizzaService.getPizzaById(pizzaId);
    }

    @GetMapping("pizza")
    public Pizza getPizzaByName(@RequestParam String pizzaName) {
        return pizzaService.getPizzaByName(pizzaName);
    }

    @PostMapping("pizza")
    public void addPizza(@RequestBody Pizza pizza) {
        pizzaService.addPizza(pizza);
    }

    @DeleteMapping("pizza/{pizzaId}")
    public void deletePizzaById(@PathVariable Long pizzaId) {
        pizzaService.deletePizzaById(pizzaId);
    }

    @DeleteMapping("pizza")
    public void deletePizzaByName(@RequestParam String pizzaName) {
        pizzaService.deletePizzaByName(pizzaName);
    }

    @PutMapping("pizza/{pizzaId}")
    public void updatePizza(@PathVariable Long pizzaId, @RequestBody Pizza updatedPizza) {
        pizzaService.updatePizza(pizzaId, updatedPizza);
    }
}
