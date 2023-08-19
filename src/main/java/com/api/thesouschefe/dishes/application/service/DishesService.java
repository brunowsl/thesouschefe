package com.api.thesouschefe.dishes.application.service;

import com.api.thesouschefe.country.application.domain.CountryDomain;
import com.api.thesouschefe.country.application.usecases.FindCountryByIdUC;
import com.api.thesouschefe.dishes.application.domain.DishesDomain;
import com.api.thesouschefe.dishes.application.repository.DishesRepository;
import com.api.thesouschefe.dishes.application.usecases.DishesUC;
import com.api.thesouschefe.globals.response.CustomResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DishesService implements DishesUC {

    private final FindCountryByIdUC findCountryByIdUC;

    private final DishesRepository dishesRepository;

    @Override
    public CustomResponse createNewDish(Request request) {
        try {
            var getCountryResponse = findCountryByIdUC.findCountryById(request.getCountryId());
            if (getCountryResponse.getHasError()) {
                return getCountryResponse;
            }

            DishesDomain dish = DishesDomain.builder()
                    .name(request.getName())
                    .description(request.getDescription())
                    .country((CountryDomain) getCountryResponse.getData())
                    .ingredients(request.getIngredients())
                    .build();

            //TODO: 2. salvar a imagem em algum repositorio (s3, por exemplo)
            Optional<DishesDomain> savedDish = dishesRepository.saveDishes(dish);
            return CustomResponse.builder()
                    .code(201)
                    .message("Dish created successfully")
                    .hasError(false)
                    .data(savedDish.get())
                    .build();
        } catch (Exception e) {
            return CustomResponse.builder()
                    .code(500)
                    .message("Internal Server Error")
                    .hasError(true)
                    .build();
        }
    }

    @Override
    public CustomResponse getAllDishes() {
        try {
            List<Optional<DishesDomain>> dishes = dishesRepository.getAllDishes();
            return CustomResponse.builder()
                    .code(200)
                    .message("Dishes retrieved successfully")
                    .hasError(false)
                    .data(dishes)
                    .build();

        } catch (Exception e) {
            return CustomResponse.builder()
                    .code(500)
                    .message("Internal Server Error")
                    .hasError(true)
                    .build();
        }

    }
}
