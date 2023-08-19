package com.api.thesouschefe.ingredients.application.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsJpaRepository extends JpaRepository<Ingredients, Long> {
}
