package com.abhi.ModernWebApplication.Request;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StudentValidator implements ConstraintValidator<ValidateStudentRequest, StudentRequest> {
    @Override
    public boolean isValid(StudentRequest studentRequest, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation(); // disable the default behavior of context to make it custom
        if(studentRequest.getAge() != null && studentRequest.getAge() > 35) {
            context.buildConstraintViolationWithTemplate("Age limit crossed")
                    .addPropertyNode("age").addConstraintViolation();
            return false;
        }
        return true;
    }
}
