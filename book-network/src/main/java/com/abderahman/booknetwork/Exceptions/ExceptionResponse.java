package com.abderahman.booknetwork.Exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionResponse {
    private Integer errorCode;
    private String exceptionDetails;
    private String errorMessage;
    private Set<String> validationErrors;
    private Map<String, String> errors;
}
