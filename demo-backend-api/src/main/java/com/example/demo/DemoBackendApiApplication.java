package com.example.demo;

import com.example.demo.dto.PagamentoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.util.Arrays;

@EnableRabbit
@SpringBootApplication
public class DemoBackendApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoBackendApiApplication.class, args);
		System.out.println("Rodando API");
	}
}
