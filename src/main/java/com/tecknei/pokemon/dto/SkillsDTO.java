package com.tecknei.pokemon.dto;

/**
 * Data Transfer Object (DTO) representing a Pokémon's skills information.
 *
 * <p>This class encapsulates various categories of Pokémon skills and abilities,
 * including normal abilities, hidden abilities, item-based modifications,
 * inheritance mechanics, and possible ability combinations.</p>
 *
 * <p>It is intended to be used as part of the Pokémon data model when transferring
 * skill-related details between layers of the application.</p>
 *
 * <p>All fields are immutable once initialized via the constructor.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * SkillsDTO skills = new SkillsDTO(
 *     "Static",
 *     "Lightning Rod",
 *     "Ability Capsule",
 *     "Ability Patch",
 *     "Inherited from Raichu",
 *     "Static + Quick Feet combo"
 * );
 * </pre>
 *
 * @author Oscar HG
 */
public class SkillsDTO {

    /** The normal ability of the Pokémon. */
    private final String normal;

    /** The hidden ability of the Pokémon. */
    private final String hidden;

    /** Ability changes or modifications via capsules. */
    private final String capsules;

    /** Ability changes or modifications via patches. */
    private final String patches;

    /** Inheritance details of the Pokémon's abilities. */
    private final String inheritance;

    /** Possible combos or ability synergies. */
    private final String combos;

    /**
     * Constructs a new {@link SkillsDTO} with all skill-related fields initialized.
     *
     * @param normal the Pokémon's normal ability
     * @param hidden the Pokémon's hidden ability
     * @param capsules ability modifications using capsules
     * @param patches ability modifications using patches
     * @param inheritance inheritance details of abilities
     * @param combos possible combos or synergies between abilities
     */
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
