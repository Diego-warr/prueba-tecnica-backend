package com.certicom.project.apirest;

import com.certicom.project.apirest.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("com.certicom.project")
@EnableJpaRepositories("com.certicom.project.repository")
@Import(SwaggerConfig.class)
@EntityScan(basePackages = {"com.certicom.project.entities"})
public class ApiRestApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
    }

}
