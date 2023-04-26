package com.productapp.product.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Bean
    @Qualifier("country")
    public WebClient countryClient(@Value("${services.country-service.uri}") String serviceHost) {
        return WebClient.builder()
                .baseUrl(serviceHost)
                .build();
    }
    
}
