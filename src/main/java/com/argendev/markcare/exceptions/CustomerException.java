package com.argendev.markcare.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerException extends RuntimeException {
    public CustomerException(String msg) {
        super(msg);
    }
}
