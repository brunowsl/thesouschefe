package com.api.thesouschefe.dishestag.application.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishesTagJpaRepository extends JpaRepository<DishesTag, Long> {
}
