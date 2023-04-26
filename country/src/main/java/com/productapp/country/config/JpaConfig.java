package com.productapp.country.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
// @EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EntityScan({"com.apachekafka.apachekafka.model", "com.productapp.country.model"})
public class JpaConfig {
    
}
