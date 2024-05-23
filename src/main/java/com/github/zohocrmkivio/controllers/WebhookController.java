package com.github.zohocrmkivio.controllers;

import com.github.zohocrmkivio.models.WebhookPayload;
import com.github.zohocrmkivio.services.WebhookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhooks")
public class WebhookController {

    private final WebhookService webhookService;

    public WebhookController(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    // Endpoint to handle Razorpay webhook
    @PostMapping("/razorpay")
    public ResponseEntity<String> handleWebhook(@RequestBody WebhookPayload webhookPayload) {
        try {
            webhookService.processWebhook(webhookPayload);
            return ResponseEntity.ok("Webhook processed successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing webhook: " + e.getMessage());
        }
    }
}
