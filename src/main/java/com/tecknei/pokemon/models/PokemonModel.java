package com.tecknei.pokemon.models;

import com.tecknei.pokemon.converters.JsonListConverter;
import com.tecknei.pokemon.converters.MapToJsonConverter;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

/**
 * JPA entity representing the Pokémon catalog.
 *
 * <p>This entity is mapped to the database table <b>pokemon_cat</b>. It stores
 * the basic attributes of a Pokémon, including its type, abilities, attacks,
 * statistics, and an image.</p>
 *
 * <p>JSONB fields are used for complex attributes such as skills, attacks, and
 * statistics, which are mapped using custom converters:
 * <ul>
 *   <li>{@link MapToJsonConverter} for mapping {@link Map} objects</li>
 *   <li>{@link JsonListConverter} for mapping {@link List} objects</li>
 * </ul>
 * </p>
 *
 * <p>The Pokémon's image is stored as a byte array in the column <b>img</b>.</p>
 *
 * <p>Example schema (PostgreSQL):</p>
 * <pre>
 * CREATE TABLE pokemon_cat (
 *     id BIGSERIAL PRIMARY KEY,
 *     name VARCHAR(255),
 *     species VARCHAR(255),
 *     type VARCHAR(255),
 *     skills JSONB,
 *     attacks JSONB,
 *     statistics JSONB,
 *     img BYTEA
 * );
 * </pre>
 *
 * @author Oscar HG
 */
@Entity
@Table(name = "pokemon_cat")
public class PokemonModel {

    /** Primary key identifier of the Pokémon. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The Pokémon's name. */
    private String name;

    /** The Pokémon's species classification. */
    private String species;

    /** The elemental type of the Pokémon (e.g., Fire, Water, Electric). */
    private String type;

    /** The Pokémon's skills or abilities, stored as JSON. */
    @Column(columnDefinition = "jsonb")
    @Convert(converter = MapToJsonConverter.class)
    private Map<String, Object> skills;

    /** The Pokémon's attacks or moves, stored as a JSON list. */
    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonListConverter.class)
    private List<String> attacks;

    /** The Pokémon's statistics (e.g., HP, Attack, Defense), stored as JSON. */
    @Column(columnDefinition = "jsonb")
    @Convert(converter = MapToJsonConverter.class)
    private Map<String, Object> statistics;

    /** The Pokémon's image stored as binary data (byte array). */
    @Column(name = "img")
    private byte[] byteImage;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public byte[] getImage() {
        return byteImage;
    }

    public void setImage(byte[] image) {
        this.byteImage = image;
    }
}
