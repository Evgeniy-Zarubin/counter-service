package org.skypro.counter.controller;

import org.skypro.counter.Exception.NoSuchProductException;
import org.skypro.counter.Exception.ShopError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> handleNoSuchProductException(NoSuchProductException exception) {
        ShopError shopError = new ShopError("PRODUCT_NOT_FOUND", exception.getMessage());
        return new ResponseEntity<>(shopError, HttpStatus.NOT_FOUND);
    }
}
