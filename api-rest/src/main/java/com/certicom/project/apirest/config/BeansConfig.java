package com.certicom.project.apirest.config;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BeansConfig {
    public static String API_NOMBRE;

    public static String API_VERSION;

    @Value("${app.server.nombre}")
    public void setApiNombre(String value){
        API_NOMBRE = value;
    }

    @Value("${app.server.version}")
    public void setApiVersion(String value){
        API_VERSION = value;
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
