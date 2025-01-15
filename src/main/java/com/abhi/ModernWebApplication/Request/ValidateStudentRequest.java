package com.abhi.ModernWebApplication.Request;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StudentValidator.class) // requires spring boot starter validator dependency in pom
public @interface ValidateStudentRequest {
    String message() default "error in student input";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
