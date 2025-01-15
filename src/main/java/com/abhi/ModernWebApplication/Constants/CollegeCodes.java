package com.abhi.ModernWebApplication.Constants;

import lombok.Getter;

@Getter
public enum CollegeCodes {
    CollegeServiceException(1001, "exception occurred while handling college data"),
    CollegeValidationException(2002, "validation error");
    final int code;
    final String message;
    CollegeCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
