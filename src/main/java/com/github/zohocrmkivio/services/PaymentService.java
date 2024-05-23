package com.github.zohocrmkivio.services;

import com.github.zohocrmkivio.models.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    public void processPayment(Payment paymentDetails) {
        System.out.println("Payment processed successfully!");
    }
}
