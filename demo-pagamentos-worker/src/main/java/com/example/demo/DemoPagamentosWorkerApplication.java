package com.example.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@EnableRabbit
@SpringBootApplication
public class DemoPagamentosWorkerApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoPagamentosWorkerApplication.class, args);
		System.out.println("Rodando Worker");
	}
}
