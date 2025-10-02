package com.tecknei.pokemon.services;

import com.tecknei.pokemon.dto.PokemonDTO;
import com.tecknei.pokemon.models.PokemonModel;
import com.tecknei.pokemon.repository.PokemonRepository;
import com.tecknei.pokemon.services.interfaces.PokemonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class PokemonService implements PokemonServiceInterface {
    private final PokemonRepository repository;

    @Autowired
    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PokemonDTO> getAll() {
        return null;
    }

    @Override
    public List<PokemonDTO> getByName(String name) {
        List<PokemonModel>l=repository.findByName(name);
        return l.stream().map((data)->new PokemonDTO(data.getName(),data.getSpecies(), data.getType(),
                 data.getSkills(), data.getAttacks(), data.getStatistics(), new String(data.getImage(), StandardCharsets.UTF_8))).toList();
    }

    @Override
    public void add(PokemonDTO pokemon) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, PokemonDTO new_pokemon) {

    }
}
