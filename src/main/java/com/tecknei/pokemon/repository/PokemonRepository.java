package com.tecknei.pokemon.repository;

import com.tecknei.pokemon.models.PokemonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<PokemonModel, Long> {
    List<PokemonModel> findByName(String name);
}
