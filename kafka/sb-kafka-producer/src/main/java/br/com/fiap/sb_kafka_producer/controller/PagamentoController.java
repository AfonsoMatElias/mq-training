package br.com.fiap.sb_kafka_producer.controller;

import br.com.fiap.sb_kafka_producer.dto.PagamentoDto;
import br.com.fiap.sb_kafka_producer.service.PagamentoService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/api/pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(
            PagamentoService pagamentoService
    ) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public String enviar(@RequestBody PagamentoDto pagamentoDto) {
        return  pagamentoService.processarPagamento(pagamentoDto);
    }
}
