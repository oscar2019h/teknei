package com.tecknei.pokemon.controllers;

import com.tecknei.pokemon.dto.ResponseErrorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

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

    @Operation(
            summary = "Handle 404 errors",
            description = "Handles HttpClientErrorException.NotFound and returns a structured error response"
    )
    @ApiResponse(responseCode = "404", description = "Resource not found")
    @ExceptionHandler(NoResourceFoundException.class)
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
