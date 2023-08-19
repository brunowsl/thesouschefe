package com.api.thesouschefe.country.application.service;

import com.api.thesouschefe.country.application.domain.CountryDomain;
import com.api.thesouschefe.country.application.respository.CountryRepository;
import com.api.thesouschefe.country.application.usecases.CountryUC;
import com.api.thesouschefe.globals.response.CustomResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryService implements CountryUC {

    private final CountryRepository countryRepository;
    @Override
    public CustomResponse findCountryById(Long id) {
        Optional<CountryDomain> countryDomain = countryRepository.getCountryById(id);
        if(countryDomain.isEmpty()){
            return CustomResponse.builder()
                    .status("Fail")
                    .code(404)
                    .hasError(true)
                    .message("Country not found. Probably the country is not supported yet.")
                    .build();
        }
        return CustomResponse.builder()
                .status("Success")
                .code(200)
                .message("Country successfully found")
                .hasError(false)
                .data(countryDomain.get())
                .build();
    }
}
