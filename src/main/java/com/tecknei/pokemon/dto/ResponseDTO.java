package com.tecknei.pokemon.dto;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Component
@RequestScope
public class ResponseDTO {
    @Qualifier("${status_code}")
    private int statusCode;
    @Qualifier("${default}")
    private String message;
    @Qualifier("${default}")
    private List<PokemonDTO> data;

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
