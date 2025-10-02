package com.tecknei.pokemon.converters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;

/**
 * JPA attribute converter for handling lists of strings as JSON.
 *
 * <p>This converter automatically transforms a {@link List}&lt;{@link String}&gt;
 * into a JSON string for database storage and converts the JSON string back
 * into a list when reading from the database.</p>
 *
 * <p>It leverages {@link ObjectMapper} from the Jackson library to perform
 * the serialization and deserialization.</p>
 *
 * <p>Usage example in an entity:</p>
 * <pre>
 * &#64;Convert(converter = JsonListConverter.class)
 * private List&lt;String&gt; abilities;
 * </pre>
 *
 * <p>This will ensure that the <b>abilities</b> field is stored as JSON in
 * the database column, but accessed as a Java {@link List} in the entity.</p>
 *
 * @author Oscar HG
 */
@Converter
public class JsonListConverter implements AttributeConverter<List<String>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Converts a {@link List} of strings into a JSON string for database storage.
     *
     * @param attribute the list of strings to serialize
     * @return a JSON string representing the list, or {@code null} if an error occurs
     * @throws RuntimeException if the serialization fails
     */
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing list to JSON", e);
        }
    }

    /**
     * Converts a JSON string from the database into a {@link List} of strings.
     *
     * @param dbData the JSON string retrieved from the database
     * @return a list of strings deserialized from the JSON string
     * @throws RuntimeException if the deserialization fails
     */
    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<List<String>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing JSON to list", e);
        }
    }
}
