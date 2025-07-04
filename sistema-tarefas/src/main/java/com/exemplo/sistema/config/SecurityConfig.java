package com.exemplo.sistema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/actuator/prometheus").permitAll() // Permit access to Prometheus endpoint
                        .anyRequest().authenticated() // All other requests need authentication
                )
                .httpBasic(Customizer.withDefaults()) // Use HTTP Basic authentication
                .csrf(csrf -> csrf.disable()); // Disable CSRF for easier API testing

        return http.build();
    }
}

