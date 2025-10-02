package com.tecknei.pokemon.controllers;

import com.tecknei.pokemon.dto.ResponseDTO;
import com.tecknei.pokemon.services.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private final  PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    public ResponseDTO getPokemon( @PathVariable String name) {
        System.out.println(name);
        ResponseDTO rst= new ResponseDTO();
        rst.setData(service.getByName(name));
        rst.setStatusCode(200);
        rst.setMessage("Successfully");
        return rst;


    }
}
