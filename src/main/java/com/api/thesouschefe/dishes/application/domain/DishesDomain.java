package com.api.thesouschefe.dishes.application.domain;

import com.api.thesouschefe.country.application.domain.CountryDomain;
import com.api.thesouschefe.dishestag.application.domain.DishesTagDomain;
import com.api.thesouschefe.ingredients.application.domain.IngredientsDomain;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class DishesDomain {
    private UUID id;
    private String name;
    private String description;
    private CountryDomain country;
    private List<IngredientsDomain> ingredients;
    private List<DishesTagDomain> tags;
}
