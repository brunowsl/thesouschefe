package com.api.thesouschefe.country.adapter.out;

import com.api.thesouschefe.country.application.database.Country;
import com.api.thesouschefe.country.application.database.CountryJpaRepository;
import com.api.thesouschefe.country.application.domain.CountryDomain;
import com.api.thesouschefe.country.application.respository.CountryRepository;
import com.api.thesouschefe.globals.mapper.CustomGenericMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CountryJpaAdapter implements CountryRepository {

    private final CountryJpaRepository countryJpaRepository;
    private final CustomGenericMapper mapper;
    @Override
    public Optional<CountryDomain> getCountryById(Long id) {
        Optional<Country> country = countryJpaRepository.findById(id);
        return country.map(value -> mapper.map(value, CountryDomain.class));
    }
}
