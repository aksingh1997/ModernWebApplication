package com.abhi.ModernWebApplication.Exception;

import lombok.Getter;

@Getter
public class CollegeException extends RuntimeException {
    private int code;
    private String errorMessage;
    public CollegeException(int code, String errorMessage, Exception ex) {
        super(ex.getMessage());
        this.code = code;
        this.errorMessage = errorMessage;
    }
}
