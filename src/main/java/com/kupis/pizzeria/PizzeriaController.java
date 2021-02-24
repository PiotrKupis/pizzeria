package com.kupis.pizzeria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PizzeriaController {

    private final PizzeriaService pizzeriaService;

    @Autowired
    public PizzeriaController(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @GetMapping("pizzeria/getPizzas")
    public List<Pizza> getPizzas(){
            return pizzeriaService.getPizzas();
    }

    @GetMapping("pizzeria/getPizza")
    public Pizza getPizza(@RequestParam String pizzaName){
        return pizzeriaService.getStudent(pizzaName);
    }
}
