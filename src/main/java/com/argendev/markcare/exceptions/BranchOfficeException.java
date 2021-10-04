package com.argendev.markcare.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BranchOfficeException extends RuntimeException {
    public BranchOfficeException(String msg) {
        super(msg);
    }
}
