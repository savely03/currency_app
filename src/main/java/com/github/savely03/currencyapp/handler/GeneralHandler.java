package com.github.savely03.currencyapp.handler;

import com.github.savely03.currencyapp.Exception.BaseException;
import com.github.savely03.currencyapp.dto.ResponseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ResponseError> handleBaseException(BaseException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(new ResponseError(e.getMessage()));
    }
}
