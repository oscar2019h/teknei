package com.tecknei.pokemon.dto;

import java.util.Date;

public class ResponseErrorDTO {
    private String message;
    private String description;
    private int statusCode;
    private Date date;

    public ResponseErrorDTO(String message, String description, int statusCode, Date date) {
        this.message = message;
        this.description = description;
        this.statusCode = statusCode;
        this.date = date;
    }

    public ResponseErrorDTO() {}

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