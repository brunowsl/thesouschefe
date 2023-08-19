package com.api.thesouschefe.globals.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponse<T> {
    private final int code;
    private final String status;
    private final String message;
    private final String developerMessage;
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final T data;
    private final Boolean hasError;
}
