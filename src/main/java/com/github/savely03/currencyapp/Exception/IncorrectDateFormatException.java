package com.github.savely03.currencyapp.Exception;

import org.springframework.http.HttpStatus;

public class IncorrectDateFormatException extends BaseException {
    public IncorrectDateFormatException() {
        super(HttpStatus.BAD_REQUEST);
    }

    @Override
    public String getMessage() {
        return "Incorrect Date format";
    }
}
