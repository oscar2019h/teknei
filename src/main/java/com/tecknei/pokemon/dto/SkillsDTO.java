package com.tecknei.pokemon.dto;

public class SkillsDTO {
    private final String normal;
    private final String hidden;
    private final String capsules;
    private final String patches;
    private final String inheritance;
    private final String combos;

    public SkillsDTO(String normal, String hidden, String capsules, String patches, String inheritance, String combos) {
        this.normal = normal;
        this.hidden = hidden;
        this.capsules = capsules;
        this.patches = patches;
        this.inheritance = inheritance;
        this.combos = combos;
    }

    public String getNormal() {
        return normal;
    }

    public String getHidden() {
        return hidden;
    }

    public String getCapsules() {
        return capsules;
    }

    public String getPatches() {
        return patches;
    }

    public String getInheritance() {
        return inheritance;
    }

    public String getCombos() {
        return combos;
    }
}
