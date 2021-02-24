package com.kupis.pizzeria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PizzeriaRepository extends JpaRepository<Pizza, Long> {

    @Query("SELECT p FROM Pizza p WHERE p.name = ?1")
    Optional<Pizza> getPizzaByName(String pizzaName);
}
