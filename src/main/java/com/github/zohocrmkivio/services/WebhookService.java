package com.github.zohocrmkivio.services;

import com.github.zohocrmkivio.models.Payment;
import com.github.zohocrmkivio.models.WebhookPayload;
import org.springframework.stereotype.Service;

@Service
public class WebhookService {

//    private final PaymentService paymentService;
    private final ZohoCRMService zohoCRMService;

    public WebhookService(ZohoCRMService zohoCRMService) {
//        this.paymentService = paymentService;
        this.zohoCRMService = zohoCRMService;
    }

    public void processWebhook(WebhookPayload webhookPayload) {
        // Process the webhook payload and save to database
        Payment payment = webhookPayload.getPayload().getPayment();
        zohoCRMService.createLead(payment);
    }
}
