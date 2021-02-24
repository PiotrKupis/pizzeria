package com.kupis.pizzeria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
