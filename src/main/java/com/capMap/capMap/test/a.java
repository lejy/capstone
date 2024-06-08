package com.capMap.capMap.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class a implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081") // 다른 포트로부터의 접근 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // 허용할 HTTP 메서드 지정
    }
}

