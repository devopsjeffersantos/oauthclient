package com.example.oauthclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration(proxyBeanMethods = false)
@EnableWebFlux
public class OAuth2ConfigClient {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange(authorize -> authorize
                        .anyExchange().authenticated()
                )
                .oauth2Login(withDefaults())
                .cors().disable();
        return http.build();
    }
    
}
