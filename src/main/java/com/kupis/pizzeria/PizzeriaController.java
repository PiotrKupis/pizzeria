package com.kupis.pizzeria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzeriaController {

    @GetMapping("pizzeria/getMenu")
    public String getPizzas(){
            return "test";
    }
}
