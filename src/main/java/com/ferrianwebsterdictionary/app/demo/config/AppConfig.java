package com.ferrianwebsterdictionary.app.demo.config;

import com.ferrianwebsterdictionary.app.demo.model.CustomWord;
import com.ferrianwebsterdictionary.app.demo.repo.WordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig implements CommandLineRunner {

    private final WordRepository wordRepository;

    public AppConfig(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        wordRepository.save(new CustomWord("2", "test", null, null, null, null, null));
    }
}
