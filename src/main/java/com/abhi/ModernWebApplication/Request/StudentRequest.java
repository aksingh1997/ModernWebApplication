package com.abhi.ModernWebApplication.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@ValidateStudentRequest
public class StudentRequest {
    @NotNull(message = "id must be provided") // Not blank requires spring-boot-starter-validator dependency in pom
    private Integer id;
    @NotBlank(message = "name must not be blank")
    private String name;
    @NotNull(message = "age cannot be null")
    private Integer age;
    private String subjectStream;
}
