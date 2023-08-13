package com.mra.exceptions;

import com.mra.payload.ApiResponse;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
       String message =ex.getMessage();
       ApiResponse response =ApiResponse.builder().msg(message).success(true).status(HttpStatus.NOT_FOUND).build();
       return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
