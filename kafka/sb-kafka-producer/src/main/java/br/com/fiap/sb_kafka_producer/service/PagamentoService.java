package br.com.fiap.sb_kafka_producer.service;

import br.com.fiap.sb_kafka_producer.dto.PagamentoDto;
import br.com.fiap.sb_kafka_producer.producer.PagamentoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private final PagamentoProducer producer;

    public PagamentoService(PagamentoProducer producer) {
        this.producer = producer;
    }

    public String processarPagamento(PagamentoDto pagamentoDto) {
        try {
            return producer.enviar(pagamentoDto);
        } catch (Exception e) {
            return ">>>> Erro ao enviar pagamento: " + e.getMessage();
        }
    }
}
