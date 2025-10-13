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

	public static class Pagamento {
		private String numeroPedido;
		private BigDecimal valor;
		private String produto;

		public String getNumeroPedido() {
			return numeroPedido;
		}

		public void setNumeroPedido(String numeroPedido) {
			this.numeroPedido = numeroPedido;
		}

		public BigDecimal getValor() {
			return valor;
		}

		public void setValor(BigDecimal valor) {
			this.valor = valor;
		}

		public String getProduto() {
			return produto;
		}

		public void setProduto(String produto) {
			this.produto = produto;
		}
	}

	public void mains() {

		ObjectMapper mapper = new ObjectMapper();

		PagamentoDto dto = new PagamentoDto();
		dto.setValor(BigDecimal.TEN);
		dto.setProduto("iPhone 16 Pro");
		dto.setNumeroPedido("PZ123O");

		Arrays.stream(Pagamento.class.getDeclaredFields()).
			forEach(x -> System.out.println(x.getName()));

		Pagamento entity = mapper.convertValue(dto, Pagamento.class);
		System.out.println(entity.getProduto());

		// SpringApplication.run(DemoBackendApiApplication.class, args);
		// System.out.println("Rodando API");

	}

	public static void main(String[] args) {
		try {
			// Get the Class object for the inner class
			Class<?> cls = Pagamento.class;

			// Get the no-arg constructor
			Constructor<?> constructor = cls.getDeclaredConstructor();

			// Create a new instance
			Object pagamentoObj = constructor.newInstance();

			// Cast to Pagamento if you want to use it directly
			Pagamento pagamento = (Pagamento) pagamentoObj;

			// Now you can set values using reflection or directly
			pagamento.setNumeroPedido("12345");
			pagamento.setValor(new BigDecimal("100.50"));
			pagamento.setProduto("Product A");

			System.out.println("Numero Pedido: " + pagamento.getNumeroPedido());
			System.out.println("Valor: " + pagamento.getValor());
			System.out.println("Produto: " + pagamento.getProduto());

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
