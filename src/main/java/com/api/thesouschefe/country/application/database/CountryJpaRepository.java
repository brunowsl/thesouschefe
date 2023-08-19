package com.api.thesouschefe.country.application.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryJpaRepository extends JpaRepository<Country, Long> {
}
