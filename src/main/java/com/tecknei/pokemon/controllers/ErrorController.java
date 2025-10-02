package com.tecknei.pokemon.controllers;

import com.tecknei.pokemon.dto.ResponseErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;

/**
 * Global exception handler for REST controllers.
 *
 * <p>This class leverages {@link RestControllerAdvice} to intercept and handle
 * exceptions across the entire application, ensuring a standardized error
 * response structure.</p>
 *
 * <p>Currently, it provides handling for {@link HttpClientErrorException.NotFound}
 * by returning a 404 response with a custom error body.</p>
 *
 * <p>The response body is represented by {@link ResponseErrorDTO}, which includes
 * key error details such as timestamp, status code, message, and description.</p>
 *
 * @author Oscar HG
 */
@RestControllerAdvice
public class ErrorController {

    /**
     * Handles {@link HttpClientErrorException.NotFound} exceptions and generates
     * a standardized error response with HTTP status <b>404 Not Found</b>.
     *
     * <p>The error response includes:</p>
     * <ul>
     *   <li><b>date</b> - the timestamp when the error occurred</li>
     *   <li><b>statusCode</b> - the HTTP status code (404)</li>
     *   <li><b>message</b> - the exception message</li>
     *   <li><b>description</b> - additional error context (here the status code)</li>
     * </ul>
     *
     * @param e the thrown {@link Exception}, specifically an instance of
     *          {@link HttpClientErrorException.NotFound}
     * @return a {@link ResponseEntity} containing the {@link ResponseErrorDTO} payload
     */
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<ResponseErrorDTO> notFoundException(Exception e) {
        ResponseErrorDTO response = new ResponseErrorDTO();
        response.setDate(new Date());
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(e.getMessage());
        response.setDescription(String.valueOf(HttpStatus.NOT_FOUND.value()));

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND.value())
                .body(response);
    }
}
