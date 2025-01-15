package com.abhi.ModernWebApplication.Exception;

import com.abhi.ModernWebApplication.Constants.CollegeCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(CollegeException.class)
    public ResponseEntity<?> handleException(CollegeException ce) {
        return ResponseEntity.status(500).body(ErrorResponse.builder()
                .errorCode(ce.getCode())
                .description(ce.getErrorMessage()).build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleException(MethodArgumentNotValidException ex) {
       // In the below line, we are trying to find out the field and exception message from methodArgument exception
        // and creating a object of ValidationError. This exception contains list of all errors due to invalid method args
        List<ValidationError> validationError = ex.getBindingResult().getAllErrors().stream()
                        .map(error -> new ValidationError(((FieldError) error).getField(), error.getDefaultMessage()))
                        .toList();
        return ResponseEntity.status(500).body(ErrorResponse.builder()
                .errorCode(CollegeCodes.CollegeValidationException.getCode())
                .description(CollegeCodes.CollegeValidationException.getMessage())
                .validationError(validationError).build());
    }
}
