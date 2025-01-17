package com.example.test3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class AlreadyExistsException extends RuntimeException {
    private String message;

    //public CustomerAlreadyExistsException() {}

    public AlreadyExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}
