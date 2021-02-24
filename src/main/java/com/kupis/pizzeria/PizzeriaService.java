package com.kupis.pizzeria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzeriaService {

    private final PizzeriaRepository pizzeriaRepository;

    @Autowired
    public PizzeriaService(PizzeriaRepository pizzeriaRepository) {
        this.pizzeriaRepository = pizzeriaRepository;
    }

    public List<Pizza> getPizzas(){
        return this.pizzeriaRepository.findAll();
    }

    public Pizza getStudent(String pizzaName) {
        Optional<Pizza> pizza = pizzeriaRepository.getPizzaByName(pizzaName);

        if(pizza.isPresent())
            return pizza.get();
        else
            throw new IllegalStateException("Lack of pizza: "+ pizzaName);
    }
}
