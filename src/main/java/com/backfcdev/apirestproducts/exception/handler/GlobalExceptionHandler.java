package com.backfcdev.apirestproducts.exception.handler;


import com.backfcdev.apirestproducts.exception.EntityNotFoundException;
import com.backfcdev.apirestproducts.exception.MediaFileNotFoundException;
import com.backfcdev.apirestproducts.exception.StorageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;

import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

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

    @ExceptionHandler(StorageException.class)
    ProblemDetail handleStorageException(StorageException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(EXPECTATION_FAILED, ex.getMessage());
        problemDetail.setTitle("Expectation Failed");
        problemDetail.setType(URI.create("/expectation-failed"));
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(MediaFileNotFoundException.class)
    ProblemDetail handleMediaFileNotFoundException(MediaFileNotFoundException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Not Found");
        problemDetail.setType(URI.create("/not-found"));
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
