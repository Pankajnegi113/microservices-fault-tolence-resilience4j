package com.java.eureka.paymentClient.rest;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class CartRestConsumer {

    private Logger logger = LoggerFactory.getLogger(CartRestConsumer.class);

    private RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "getCartProductsDetails", fallbackMethod = "getCartProductsFallback")
    public String getCartProductsDetails() {
        String url = "http://localhost:8090/cart/getData";
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }

    public String getCartProductsFallback(Exception e) {
        logger.info("---RESPONSE FROM FALLBACK METHOD---");
        return "SERVICE IS DOWN, PLEASE TRY AFTER SOMETIME !!!";
    }
}
