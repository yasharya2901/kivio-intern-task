package com.github.zohocrmkivio.controllers;

import com.github.zohocrmkivio.models.Payment;
import com.github.zohocrmkivio.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Endpoint to handle payment creation
    @PostMapping
    public String createPayment(@RequestBody Payment paymentDetails) {
        paymentService.processPayment(paymentDetails);
        return "Payment created successfully!";
    }
}
