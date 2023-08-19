package com.api.thesouschefe.ingredientstag.application.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsTagJpaRepository extends JpaRepository<IngredientsTag, Long> {
}
