package com.kupis.pizzeria.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("pizzeria/getPizzas")
    public List<Pizza> getPizzas() {
        return pizzaService.getPizzas();
    }

    @GetMapping("pizzeria/getPizza")
    public Pizza getPizza(@RequestParam String pizzaName){
        return pizzaService.getStudent(pizzaName);
    }
}
