package com.commerce.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("http://localhost:8080").description("Development server")) // Local server
                .info(new Info()
                        .title("Product Management API")
                        .version("1.0")
                        .description("API for managing products in an e-commerce system.")
                        .contact(new Contact()
                                .name("Customer Support")
                                .url("http://yourwebsite.com/support")
                                .email("support@yourwebsite.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                );
    }
}
