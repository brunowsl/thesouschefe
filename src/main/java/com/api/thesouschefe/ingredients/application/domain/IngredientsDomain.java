package com.api.thesouschefe.ingredients.application.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IngredientsDomain {
    private Long id;
    private String name;
    private Integer quantity;
    private String unit;
}
