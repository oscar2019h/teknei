package com.tecknei.pokemon.dto;

import java.util.List;
import java.util.Map;

/**
 * Data Transfer Object (DTO) representing a Pokémon entity.
 *
 * <p>This class is used to encapsulate Pokémon information and transfer it
 * between layers of the application, particularly from the service layer to
 * the controller layer.</p>
 *
 * <p>The object includes basic Pokémon details, abilities, attacks, statistics,
 * and an image URL.</p>
 *
 * <p>Typical usage example:</p>
 * <pre>
 * PokemonDTO pikachu = new PokemonDTO(
 *     "Pikachu",
 *     "Mouse Pokémon",
 *     "Electric",
 *     Map.of("static", true, "lightning-rod", false),
 *     List.of("Thunderbolt", "Quick Attack"),
 *     Map.of("hp", 35, "attack", 55, "speed", 90),
 *     "https://example.com/pikachu.png"
 * );
 * </pre>
 *
 * @author Oscar HG
 */
public class PokemonDTO {

    /** The name of the Pokémon. */
    private String name;

    /** The species classification of the Pokémon. */
    private String species;

    /** The elemental type of the Pokémon (e.g., Fire, Water, Electric). */
    private String type;

    /** A map representing the Pokémon's skills or abilities. */
    private Map<String, Object> skills;

    /** A list of attacks or moves the Pokémon can perform. */
    private List<String> attacks;

    /** A map containing the Pokémon's statistics (e.g., HP, Attack, Defense). */
    private Map<String, Object> statistics;

    /** A URL or path to the Pokémon's image. */
    private String image;

    /**
     * Constructs a new {@link PokemonDTO} with all fields initialized.
     *
     * @param name the Pokémon's name
     * @param species the Pokémon's species
     * @param type the Pokémon's elemental type
     * @param skills a map of the Pokémon's skills/abilities
     * @param attacks a list of the Pokémon's attacks
     * @param statistics a map containing the Pokémon's statistics
     * @param image a URL or path to the Pokémon's image
     */
    public PokemonDTO(
            String name,
            String species,
            String type,
            Map<String, Object> skills,
            List<String> attacks,
            Map<String, Object> statistics,
            String image) {
        this.name = name;
        this.species = species;
        this.type = type;
        this.skills = skills;
        this.attacks = attacks;
        this.statistics = statistics;
        this.image = image;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, Object> skills) {
        this.skills = skills;
    }

    public List<String> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<String> attacks) {
        this.attacks = attacks;
    }

    public Map<String, Object> getStatistics() {
        return statistics;
    }

    public void setStatistics(Map<String, Object> statistics) {
        this.statistics = statistics;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
