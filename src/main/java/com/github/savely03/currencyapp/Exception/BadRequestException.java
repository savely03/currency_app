package com.github.savely03.currencyapp.Exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException {
    public BadRequestException() {
        super(HttpStatus.BAD_REQUEST);

    }

    @Override
    public String getMessage() {
        return "Something went wrong";
    }
}
