package com.backfcdev.apirestproducts.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Gibbsson J. A. Farias Castillo",
                        email = "gibbfarc17@gmail.com",
                        url = "https://github.com/gibbssonfarias30"
                ),
                description = "OpenAPI documentation for Rest API Products",
                title = "OpenApi specification - backfcdev",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:9898"
                )
        }
)
@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
