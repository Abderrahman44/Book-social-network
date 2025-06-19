package com.abderahman.booknetwork.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static org.springframework.http.HttpStatus.*;


public enum BusinessErrorCodes {
    NO_CODE(0, NOT_IMPLEMENTED, "No code"),
    INCORRECT_CURRENT_PASSWORD(300, BAD_REQUEST, "Incorrect current password"),
    NEW_PASSWORD_DOES_NOT_MATCH(301, BAD_REQUEST, "The new password does not match"),
    ACCOUNT_LOCKED(302, FORBIDDEN, "User account is locked"),
    ACCOUNT_DISABLED(303, FORBIDDEN, "user account is disabled"),
    BAD_CREDENTIALS(304, FORBIDDEN, "Login and / password is incorrect"),
    ;
    @Getter
    private final int code;
    @Getter
    private final String details;
    @Getter
    private final HttpStatus httpStatus;

    BusinessErrorCodes(int code,  HttpStatus httpStatus,String details) {
        this.code = code;
        this.details = details;
        this.httpStatus = httpStatus;
    }
}
