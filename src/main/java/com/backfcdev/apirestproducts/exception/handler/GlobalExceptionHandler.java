package com.backfcdev.apirestproducts.exception.handler;


import com.backfcdev.apirestproducts.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    ProblemDetail handleEntityNotFoundException(EntityNotFoundException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, null);
        problemDetail.setTitle("Entity Not Found");
        problemDetail.setType(URI.create("/not-found"));
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
