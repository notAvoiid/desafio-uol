package com.imrzoom.desafiouol.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Desafio UOL - Player Management")
                        .version("v1.0")
                        .description("API for managing players. Provides endpoints for creating, retrieving, and managing players.")
                        .termsOfService("https://github.com/notAvoiid")
                        .contact(new Contact()
                                .name("Developer Support")
                                .url("https://github.com/notAvoiid")
                                .email("igorabreu.dev@example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
