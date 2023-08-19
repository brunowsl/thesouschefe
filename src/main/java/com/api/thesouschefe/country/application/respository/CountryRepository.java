package com.api.thesouschefe.country.application.respository;

import com.api.thesouschefe.country.application.domain.CountryDomain;

import java.util.Optional;

public interface CountryRepository {
    Optional<CountryDomain> getCountryById(Long id);
}
