package com.api.thesouschefe.dishes.application.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DishesJpaRepository extends JpaRepository<Dishes, UUID> {
    List<Dishes> findDishesByNameIsContainingIgnoreCase(String name);
}
