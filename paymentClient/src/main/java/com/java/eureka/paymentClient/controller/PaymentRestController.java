package com.java.eureka.paymentClient.controller;

import com.java.eureka.paymentClient.rest.CartRestConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {

    @Autowired
    private CartRestConsumer consumer;

    @GetMapping("/data")
    public String getPaymentData() {
        return "From Payment Service: " + consumer.getCartProductsDetails();
    }
}
