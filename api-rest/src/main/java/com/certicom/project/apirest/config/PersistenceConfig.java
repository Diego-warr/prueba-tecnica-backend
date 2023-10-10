package com.certicom.project.apirest.config;

import com.certicom.project.entities.audit.UsuarioAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware", modifyOnCreate = false)
public class PersistenceConfig {
    @Bean
    public AuditorAware<String> auditorAware() {
        return new UsuarioAuditorAware();
    }
}
