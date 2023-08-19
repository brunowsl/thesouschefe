package com.api.thesouschefe.dishes.application.usecases;

import com.api.thesouschefe.globals.response.CustomResponse;
import com.api.thesouschefe.ingredients.application.domain.IngredientsDomain;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CreateNewDishUC {
    CustomResponse createNewDish(Request request);

    @Getter
    @Builder
    class Request {
        public String name;
        public String description;
        public Long countryId;
        public MultipartFile image;
        public List<IngredientsDomain> ingredients;
    }
}
