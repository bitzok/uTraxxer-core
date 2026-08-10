package com.utraxxer.core.identity.infrastructure.in.handler;

import com.utraxxer.core.identity.domain.exception.InvalidCredentialsException;
import com.utraxxer.core.identity.infrastructure.in.handler.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handlerException(IllegalArgumentException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(400);
        errorResponse.setError("Bad Request");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(java.time.LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> credentialsException(InvalidCredentialsException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(401);
        errorResponse.setError("Unauthorized");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(java.time.LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }
}
