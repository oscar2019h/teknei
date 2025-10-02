package com.tecknei.pokemon.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger/OpenAPI configuration for the Pokemon API.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI pokemonOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Pokemon API")
                        .description("API documentation for the Pokemon application")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Tecknei")
                                .email("support@tecknei.com")
                                .url("https://www.tecknei.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
