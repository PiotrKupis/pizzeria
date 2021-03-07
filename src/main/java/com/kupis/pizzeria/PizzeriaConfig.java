package com.kupis.pizzeria;

import com.kupis.pizzeria.pizza.Pizza;
import com.kupis.pizzeria.pizza.PizzaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class PizzeriaConfig {

    @Bean
    CommandLineRunner commandLineRunner(PizzaRepository pizzaRepository) {
        return args -> {
            Pizza margherita = new Pizza("Margherita", "ser, oregano", new BigDecimal(23));
            Pizza salame = new Pizza("Salame", "ser, oregano, salami, ogórek", new BigDecimal(28));
            Pizza cappricciosa = new Pizza("Capricciosa", "ser, oregano, szynka, pieczarki", new BigDecimal(28));
            Pizza pepperoni = new Pizza("Pepperoni", "ser, oregano, kabanos, szynka, peperoni", new BigDecimal("31.5"));
            Pizza hawai = new Pizza("Hawai", "ser, oregano, szynka, ananas", new BigDecimal(28));

            pizzaRepository.saveAll(List.of(margherita, salame, cappricciosa, pepperoni, hawai));
        };
    }
}
