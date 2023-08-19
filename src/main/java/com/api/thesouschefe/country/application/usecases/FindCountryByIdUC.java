package com.api.thesouschefe.country.application.usecases;

import com.api.thesouschefe.globals.response.CustomResponse;

public interface FindCountryByIdUC {
    CustomResponse findCountryById(Long id);

}
