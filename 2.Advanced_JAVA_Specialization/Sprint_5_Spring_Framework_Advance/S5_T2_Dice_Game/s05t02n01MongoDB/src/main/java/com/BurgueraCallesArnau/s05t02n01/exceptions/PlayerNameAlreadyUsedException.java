package com.BurgueraCallesArnau.s05t02n01.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PlayerNameAlreadyUsedException extends RuntimeException {
    public PlayerNameAlreadyUsedException(String message) {
        super(message);
    }
}
