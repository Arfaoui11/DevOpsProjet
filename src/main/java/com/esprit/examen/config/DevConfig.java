package com.esprit.examen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//NOSONAR
@Configuration
@EnableWebMvc
@SuppressWarnings({"squid:S00X1", "squid:S00X2"})
public class DevConfig implements WebMvcConfigurer {
    //NOSONAR
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200");
    }
}