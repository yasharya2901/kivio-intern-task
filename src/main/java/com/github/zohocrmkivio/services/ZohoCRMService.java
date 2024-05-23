package com.github.zohocrmkivio.services;

import com.github.zohocrmkivio.models.Payment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZohoCRMService {

    private final RestTemplate restTemplate;
    private final String zohoApiUrl;
    private final String accessToken;

    public ZohoCRMService(RestTemplate restTemplate, String zohoApiUrl, String accessToken) {
        this.restTemplate = restTemplate;
        this.zohoApiUrl = zohoApiUrl;
        this.accessToken = accessToken;
    }

    public void createLead(Payment payment) {

        String leadData = String.format(
                "{ \"data\": [ { \"Company\": \"Test Company\", \"Last_Name\": \"User\", \"First_Name\": \"Test\", \"Email\": \"test.user@example.com\", \"Lead_Source\": \"Razorpay\", \"Amount\": \"%s\" } ] }",
                payment.getAmount()
        );

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Zoho-oauthtoken " + accessToken);
        headers.set("Content-Type", "application/json");

        HttpEntity<String> request = new HttpEntity<>(leadData, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                zohoApiUrl + "/leads",
                HttpMethod.POST,
                request,
                String.class
        );

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Failed to create lead in Zoho CRM: " + response.getBody());
        }
    }
}
