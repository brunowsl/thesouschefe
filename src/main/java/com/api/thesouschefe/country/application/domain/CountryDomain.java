package com.api.thesouschefe.country.application.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CountryDomain {
    private Integer id;
    private String name;
    private String code;
}
