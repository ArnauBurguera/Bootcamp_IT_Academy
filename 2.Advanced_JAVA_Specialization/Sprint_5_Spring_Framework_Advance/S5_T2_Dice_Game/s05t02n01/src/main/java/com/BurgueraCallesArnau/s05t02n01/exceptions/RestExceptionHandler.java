package com.BurgueraCallesArnau.s05t02n01.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<Object> handlePlayerNotFoundException(PlayerNotFoundException ex) {
        String response = ex.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<Object> PlayerNameAlreadyUsedException(PlayerNameAlreadyUsedException ex) {
        String response = ex.getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

}
