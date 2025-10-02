package com.tecknei.pokemon.dto;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * Standard response wrapper for REST API responses.
 *
 * <p>This DTO provides a consistent structure for API responses returned by
 * controllers. It contains:</p>
 * <ul>
 *   <li><b>statusCode</b> - the HTTP status code of the response</li>
 *   <li><b>message</b> - a human-readable description of the response outcome</li>
 *   <li><b>data</b> - the response payload, typically a list of {@link PokemonDTO}</li>
 * </ul>
 *
 * <p>It is annotated with {@link Component} and {@link RequestScope}, which means
 * a new instance will be created for each HTTP request, ensuring thread safety
 * when used in a web environment.</p>
 *
 * <p>Example usage in a controller:</p>
 * <pre>
 * ResponseDTO response = new ResponseDTO();
 * response.setStatusCode(200);
 * response.setMessage("Success");
 * response.setData(List.of(pokemon));
 * return response;
 * </pre>
 *
 * @author Oscar HG
 */
@Component
@RequestScope
public class ResponseDTO {

    /** The HTTP status code of the response (e.g., 200, 404). */
    @Qualifier("${status_code}")
    private int statusCode;

    /** A human-readable message describing the response. */
    @Qualifier("${default}")
    private String message;

    /** The response data, typically a list of {@link PokemonDTO} objects. */
    @Qualifier("${default}")
    private List<PokemonDTO> data;

    // Getters and setters

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PokemonDTO> getData() {
        return data;
    }

    public void setData(List<PokemonDTO> data) {
        this.data = data;
    }
}
