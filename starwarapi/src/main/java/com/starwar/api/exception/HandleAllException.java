package com.starwar.api.exception;

import org.springframework.boot.actuate.endpoint.InvalidEndpointRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandleAllException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({StarWarItemIdNotFoundException.class})
    public ResponseEntity<String> handleStarWarItemNotFoundException(StarWarItemIdNotFoundException starWarItemIdNotFoundException)
    {
        return new ResponseEntity<String>(starWarItemIdNotFoundException.message + " "  + starWarItemIdNotFoundException.id, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StarWarItemNameNotFoundException.class)
    public ResponseEntity<String> handleStarWarItemNameNotFoundException(StarWarItemNameNotFoundException starWarItemNameNotFoundException)
    {
        return new ResponseEntity<String>(starWarItemNameNotFoundException.message + " "  + starWarItemNameNotFoundException.name, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidEndpointRequestException.class)
    public ResponseEntity<String> handleInvalidEndpointRequestException(InvalidEndpointRequestException invalidEndpointRequestException)
    {
        return  new ResponseEntity<String>(invalidEndpointRequestException.getMessage() + " " + invalidEndpointRequestException.getReason(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> handleUsernameNotFoundException(UsernameNotFoundException usernameNotFoundException)
    {
        return  new ResponseEntity<String>(usernameNotFoundException.getMessage()  , HttpStatus.FORBIDDEN);
    }
}
