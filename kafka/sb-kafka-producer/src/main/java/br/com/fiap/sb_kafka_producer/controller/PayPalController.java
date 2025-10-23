package br.com.fiap.sb_kafka_producer.controller;

import br.com.fiap.sb_kafka_producer.service.PayPalService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/paypal")
public class PayPalController {

    private final PayPalService payPalService;

    public PayPalController(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @PostMapping("/orders")
    public Map<?,?> createOrder(@RequestBody Map<String, Object> payload) {
        return payPalService.createOrder(payload);
    }
}
