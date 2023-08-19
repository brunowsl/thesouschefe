package com.api.thesouschefe.dishes.application.usecases;

import com.api.thesouschefe.globals.response.CustomResponse;

import java.util.UUID;

public interface GetDishByIdUC {
    CustomResponse getDishById(UUID id);
}
