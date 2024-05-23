package com.github.zohocrmkivio.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ZohoCRMConfig {

    @Value("${zoho.crm.api.url}")
    private String zohoApiUrl;

    @Value("${zoho.crm.access.token}")
    private String accessToken;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public String zohoApiUrl() {
        return zohoApiUrl;
    }

    @Bean
    public String accessToken() {
        return accessToken;
    }
}

