package com.abhi.ModernWebApplication.Exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    int errorCode;
    String description;
    List<ValidationError> validationError;
}
