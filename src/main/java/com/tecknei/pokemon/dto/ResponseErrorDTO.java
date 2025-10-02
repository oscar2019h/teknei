package com.tecknei.pokemon.dto;

import java.util.Date;

/**
 * Data Transfer Object (DTO) representing standardized error responses.
 *
 * <p>This class is used to encapsulate error details returned by the API,
 * ensuring a consistent format across all endpoints.</p>
 *
 * <p>The object includes:</p>
 * <ul>
 *   <li><b>message</b> - a human-readable description of the error</li>
 *   <li><b>description</b> - additional context or details about the error</li>
 *   <li><b>statusCode</b> - the associated HTTP status code</li>
 *   <li><b>date</b> - the timestamp of when the error occurred</li>
 * </ul>
 *
 * <p>It is typically returned by the global exception handler
 * ({@code ErrorController}) when an error occurs in the application.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * ResponseErrorDTO error = new ResponseErrorDTO();
 * error.setMessage("Resource not found");
 * error.setDescription("The requested Pokémon does not exist");
 * error.setStatusCode(404);
 * error.setDate(new Date());
 * </pre>
 *
 * @author Oscar HG
 */
public class ResponseErrorDTO {

    /** A human-readable message describing the error. */
    private String message;

    /** Additional context or details about the error. */
    private String description;

    /** The HTTP status code associated with the error. */
    private int statusCode;

    /** The timestamp when the error occurred. */
    private Date date;

    /**
     * Constructs a new {@link ResponseErrorDTO} with all fields initialized.
     *
     * @param message the error message
     * @param description additional details about the error
     * @param statusCode the associated HTTP status code
     * @param date the timestamp of when the error occurred
     */
    public ResponseErrorDTO(String message, String description, int statusCode, Date date) {
        this.message = message;
        this.description = description;
        this.statusCode = statusCode;
        this.date = date;
    }

    /** Default constructor for creating an empty error response. */
    public ResponseErrorDTO() {}

    // Getters and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
