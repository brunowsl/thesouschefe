package com.api.thesouschefe.dishes.application.repository;

import com.api.thesouschefe.dishes.application.domain.DishesDomain;

import java.util.List;
import java.util.Optional;

public interface DishesRepository {
    Optional<DishesDomain> saveDishes(DishesDomain dishesDomain);

    List<Optional<DishesDomain>> getAllDishes();
}
