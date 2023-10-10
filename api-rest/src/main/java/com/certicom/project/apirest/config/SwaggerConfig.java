package com.certicom.project.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.certicom.project.apirest.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Prueba técnica API",
                "Documentacion de la API para el puesto de developer fullstack",
                "1.0.0",
                "https://drodriguez.com.pe",
                new Contact("Diego Rodriguez", "https://drodriguez.com.pe", "mark.sergen@gmail.com.pe"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
