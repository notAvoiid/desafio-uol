package com.imrzoom.desafiouol.exceptions.handler;

import com.imrzoom.desafiouol.exceptions.ErrorMessage;
import com.imrzoom.desafiouol.exceptions.NoSuchElementException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {


    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<ErrorMessage> noSuchElementException(
            NoSuchElementException ex, HttpServletRequest request){

        log.error("API Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

}
