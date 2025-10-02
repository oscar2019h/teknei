package com.tecknei.pokemon.dto;


import java.util.List;
import java.util.Map;

public class PokemonDTO {
    private String name;
    private String species;
    private String type;
    private Map<String, Object> skills;
    private List<String> attacks;
    private Map<String, Object> statistics;
    private String image;

    public PokemonDTO(String name, String species, String type, Map<String, Object> skills, List<String> attacks, Map<String, Object> statistics, String image) {
        this.name = name;
        this.species = species;
        this.type = type;
        this.skills = skills;
        this.attacks = attacks;
        this.statistics = statistics;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
