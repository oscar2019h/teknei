package com.tecknei.pokemon.controllers;

import com.tecknei.pokemon.dto.ResponseErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<ResponseErrorDTO>notFoundException(Exception e){
        ResponseErrorDTO response=new ResponseErrorDTO();
        response.setDate(new Date());
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(e.getMessage());
        response.setDescription(String.valueOf(HttpStatus.NOT_FOUND.value()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(response);
    }
}
