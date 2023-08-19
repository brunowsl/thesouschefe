package com.api.thesouschefe.dishes.adapter.out;

import com.api.thesouschefe.dishes.application.database.Dishes;
import com.api.thesouschefe.dishes.application.database.DishesJpaRepository;
import com.api.thesouschefe.dishes.application.domain.DishesDomain;
import com.api.thesouschefe.dishes.application.repository.DishesRepository;
import com.api.thesouschefe.globals.mapper.CustomGenericMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DishesJpaAdapter implements DishesRepository {

    private final DishesJpaRepository dishesJpaRepository;
    private final CustomGenericMapper mapper;

    @Override
    public Optional<DishesDomain> saveDishes(DishesDomain dishesDomain) {
        try {
            Dishes dish = mapper.map(dishesDomain, Dishes.class);
            Dishes savedDishes = dishesJpaRepository.save(dish);
            return Optional.of(mapper.map(savedDishes, DishesDomain.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Optional<DishesDomain>> getAllDishes() {
        try {
            List<Dishes> dishes = dishesJpaRepository.findAll();
            return dishes.stream()
                    .map(dish -> Optional.of(mapper.map(dish, DishesDomain.class)))
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<DishesDomain> getDishById(UUID id) {
        try {
            Optional<Dishes> dish = dishesJpaRepository.findById(id);
            return dish.map(dishes -> mapper.map(dishes, DishesDomain.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Optional<DishesDomain>> getDishesByName(String name) {
        try {
            List<Dishes> dishes = dishesJpaRepository.findDishesByNameIsContainingIgnoreCase(name);
            return dishes.stream()
                    .map(dish -> Optional.of(mapper.map(dish, DishesDomain.class)))
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
