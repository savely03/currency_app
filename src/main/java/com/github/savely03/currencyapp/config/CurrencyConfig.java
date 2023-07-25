package com.github.savely03.currencyapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CurrencyConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
