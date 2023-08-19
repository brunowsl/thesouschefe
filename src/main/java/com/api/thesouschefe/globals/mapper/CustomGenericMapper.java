package com.api.thesouschefe.globals.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomGenericMapper {
    private final ObjectMapper objectMapper;

    public <T> T map(Object source, Class<T> destinationType) {
        return objectMapper.convertValue(source, destinationType);
    }

}
