package com.tecknei.pokemon.services.interfaces;

import com.tecknei.pokemon.dto.PokemonDTO;
import com.tecknei.pokemon.models.PokemonModel;

import java.util.List;

public interface PokemonServiceInterface {
    public List<PokemonDTO> getAll();

    public List<PokemonDTO> getByName(String name);

    public void add(PokemonDTO pokemon);

    public void delete(int id);

    public void update(int id, PokemonDTO new_pokemon);
}
