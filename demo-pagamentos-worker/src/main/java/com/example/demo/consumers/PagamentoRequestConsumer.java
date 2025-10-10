package com.example.demo.consumers;

import com.example.demo.producers.PagamentoErroProducer;
import com.example.demo.producers.PagamentoSucessoProducer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PagamentoRequestConsumer {
    @Autowired PagamentoErroProducer erroProducer;
    @Autowired PagamentoSucessoProducer sucessoProducer;

    @RabbitListener(queues = { "pagamento-request-queue" })
    public void receberMensagem(@Payload Message message) {
        System.out.println(message);

        if (new Random().nextBoolean()){
            sucessoProducer.gerarResposta("Mensagem de sucesso no pagamento" + message);
        } else {
            erroProducer.gerarResposta("ERRO no pagamento" + message);
        }
    }
}
