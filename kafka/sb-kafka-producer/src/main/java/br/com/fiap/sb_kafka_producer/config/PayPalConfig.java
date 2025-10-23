package br.com.fiap.sb_kafka_producer.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PayPalConfig {
    @Value("${paypal.api-base-url}")
    private String apiBaseUrl;

    @Value("${paypal.client-id}")
    private String client;

    @Value("${paypal.client-secret}")
    private String clientSecret ;
}
