package com.dreamidea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * boot run main
 * @author  stillChina
 */

@SpringBootApplication
public class WebApplication{

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.
                        addMapping("/greeting").
                        allowedOrigins("http://localhost:3000").
                        allowedMethods(HttpMethod.GET.name(), HttpMethod.HEAD.name(), HttpMethod.POST.name(), HttpMethod.PUT.name()).
                        exposedHeaders(HttpHeaders.SET_COOKIE).
                        allowCredentials(true).
                        maxAge(1800L);;
            }
        };
    }
}
