package com.challenge.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ChallengeException extends RuntimeException {
    public ChallengeException() {
        super();
    }

    public ChallengeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChallengeException(String message) {
        super(message);
    }

    public ChallengeException(Throwable cause) {
        super(cause);
    }
}