package com.github.savely03.currencyapp.Exception;

import org.springframework.http.HttpStatus;

public class CurrencyNotFoundException extends BaseException {

    private final String code;
    public CurrencyNotFoundException(String code) {
        super(HttpStatus.NOT_FOUND);
        this.code = code;
    }

    @Override
    public String getMessage() {
        return String.format("Валюта с кодом - %s не найдена", code);
    }
}
