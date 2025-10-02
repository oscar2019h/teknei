package com.tecknei.pokemon.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

import java.io.IOException;
import java.util.Map;

/**
 * JPA attribute converter for handling {@link Map} objects as JSON strings.
 *
 * <p>This converter automatically serializes a {@link Map}&lt;{@link String}, {@link Object}&gt;
 * into a JSON string for database storage, and deserializes a JSON string back into a Map
 * when reading from the database.</p>
 *
 * <p>It uses Jackson's {@link ObjectMapper} for serialization and deserialization.</p>
 *
 * <p>Usage example in an entity:</p>
 * <pre>
 * &#64;Convert(converter = MapToJsonConverter.class)
 * private Map&lt;String, Object&gt; metadata;
 * </pre>
 *
 * <p>This will ensure that the <b>metadata</b> field is stored as JSON in the database,
 * but accessed as a Java {@link Map} in the entity.</p>
 *
 * @author Oscar HG
 */
public class MapToJsonConverter implements AttributeConverter<Map<String, Object>, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Converts a {@link Map} into a JSON string for database storage.
     *
     * @param attribute the map to be converted, may be {@code null}
     * @return the JSON string representation of the map, or {@code null} if the input is null
     * @throws RuntimeException if the serialization process fails
     */
    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {
        if (attribute == null) return null;
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting Map to JSON", e);
        }
    }

    /**
     * Converts a JSON string from the database into a {@link Map}.
     *
     * @param dbData the JSON string retrieved from the database, may be {@code null}
     * @return the deserialized {@link Map}, or {@code null} if the input is null
     * @throws RuntimeException if the deserialization process fails
     */
    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        try {
            return objectMapper.readValue(dbData, Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON to Map", e);
        }
    }
}
