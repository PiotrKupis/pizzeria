package com.kupis.pizzeria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class PizzeriaConfig {

    @Bean
    CommandLineRunner commandLineRunner(PizzeriaRepository pizzeriaRepository) {
        return args -> {
            Pizza margherita = new Pizza("Margherita", "ser, oregano", new BigDecimal(23));
            Pizza salame = new Pizza("Salame", "ser, oregano, salami, ogórek", new BigDecimal(28));

            pizzeriaRepository.saveAll(List.of(margherita, salame));
        };
    }
}
