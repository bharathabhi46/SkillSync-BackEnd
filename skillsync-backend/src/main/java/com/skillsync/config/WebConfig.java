package com.skillsync.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // allow all endpoints
                        .allowedOrigins("https://skillsyncfullstack.netlify.app") // your frontend origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // allow necessary methods
                        .allowedHeaders("*") // allow all headers
                        .allowCredentials(true); // if you use cookies/auth headers
            }
        };
    }
}
