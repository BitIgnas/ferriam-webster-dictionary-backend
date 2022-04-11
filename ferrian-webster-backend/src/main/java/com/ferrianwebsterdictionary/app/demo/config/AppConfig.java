package com.ferrianwebsterdictionary.app.demo.config;

import com.ferrianwebsterdictionary.app.demo.model.CustomWord;
import com.ferrianwebsterdictionary.app.demo.repo.WordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
