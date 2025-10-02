package com.tecknei.pokemon.controllers;

import com.tecknei.pokemon.dto.ResponseDTO;
import com.tecknei.pokemon.services.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling Pokémon-related requests.
 *
 * <p>This controller exposes endpoints under the <b>/pokemon</b> path, allowing
 * clients to retrieve Pokémon information by name.</p>
 *
 * <p>It delegates business logic to {@link PokemonService} and returns results
 * wrapped in a {@link ResponseDTO} object for consistent response formatting.</p>
 *
 * <p>The response structure includes:</p>
 * <ul>
 *   <li><b>data</b> - the Pokémon information retrieved from the service</li>
 *   <li><b>statusCode</b> - the HTTP status code (200 for success)</li>
 *   <li><b>message</b> - a human-readable message describing the outcome</li>
 * </ul>
 *
 * @author Oscar HG
 */
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService service;

    /**
     * Constructor-based dependency injection for {@link PokemonService}.
     *
     * @param service the service responsible for retrieving Pokémon data
     */
    public PokemonController(PokemonService service) {
        this.service = service;
    }

    /**
     * Retrieves a Pokémon by its name.
     *
     * <p>This endpoint handles GET requests to <b>/pokemon/{name}</b>, where
     * <i>{name}</i> is the name of the Pokémon to retrieve.</p>
     *
     * <p>The result is wrapped inside a {@link ResponseDTO} object.</p>
     *
     * @param name the name of the Pokémon to look up
     * @return a {@link ResponseDTO} containing the Pokémon data, status code,
     *         and a success message
     */
    @GetMapping("/{name}")
    public ResponseDTO getPokemon(@PathVariable String name) {
        System.out.println(name);
        ResponseDTO rst = new ResponseDTO();
        rst.setData(service.getByName(name));
        rst.setStatusCode(200);
        rst.setMessage("Successfully");
        return rst;
    }
}
