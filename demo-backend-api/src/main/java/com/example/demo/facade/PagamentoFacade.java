package com.example.demo.facade;

import com.example.demo.dto.PagamentoDto;
import com.example.demo.producers.PagamentoRequestProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoFacade {
    @Autowired
    private PagamentoRequestProducer producer;

    public String solicitarPagamento(PagamentoDto request) {
        try {
            producer.integrar(request);
        } catch (JsonProcessingException e) {
            return "Ocorreu um erro ao solicitar o pagamento. " + e.getMessage();
        }
        return "Aguardando confirmação de Pagamento...";
    }

    public void erroPagamento(String payload) {
        System.out.println("== Resposta Erro ==");
    }

    public void sucessoPagamento(String payload) {
        System.out.println("== Sucesso Erro ==");
    }
}
