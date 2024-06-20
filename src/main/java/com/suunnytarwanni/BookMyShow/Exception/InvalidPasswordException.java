package com.suunnytarwanni.BookMyShow.Exception;


import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String s) {
        super(s);
    }
}
