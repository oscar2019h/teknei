package com.tecknei.pokemon.repository;

import com.tecknei.pokemon.models.PokemonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for the {@link PokemonModel} entity.
 * Extends {@link JpaRepository} to provide basic CRUD (Create, Read, Update, Delete)
 * operations, as well as paging and sorting functionalities for Pokemon objects.
 *
 * <p>The type of the managed entity is {@code PokemonModel} and the type of the
 * primary identifier is {@code Long}.</p>
 *
 * @author Oscar HG
 * @since 1.0 (Optional: add the version)
 */
public interface PokemonRepository extends JpaRepository<PokemonModel, Long> {

    /**
     * Finds and retrieves a list of {@link PokemonModel} objects whose name
     * exactly matches the provided value.
     *
     * <p>This method follows Spring Data JPA's Query Method naming convention.</p>
     *
     * @param name The exact name of the Pokémon to search for.
     * @return A {@link List} of {@link PokemonModel} objects matching the name.
     * Returns an empty list if no Pokémon with that name is found.
     *
     */
    List<PokemonModel> findByName(String name);
}