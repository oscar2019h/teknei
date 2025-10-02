package com.tecknei.pokemon.models;

import com.tecknei.pokemon.converters.JsonListConverter;
import com.tecknei.pokemon.converters.MapToJsonConverter;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "pokemon_cat")
public class PokemonModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String species;
    private String type;
    @Column(columnDefinition = "jsonb")
    @Convert(converter = MapToJsonConverter.class)
    private  Map<String, Object> skills;
    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonListConverter.class)
    private List<String> attacks;
    @Column(columnDefinition = "jsonb")
    @Convert(converter = MapToJsonConverter.class)
    private  Map<String, Object> statistics;
    @Column(name = "img")
    private byte[] byteImage;

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
