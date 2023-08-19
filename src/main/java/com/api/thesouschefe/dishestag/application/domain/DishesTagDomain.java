package com.api.thesouschefe.dishestag.application.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DishesTagDomain {
    private Long id;
    private String name;
}
