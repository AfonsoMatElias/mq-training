package com.example.demo.consumers;

import com.example.demo.facade.PagamentoFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoResponseErroConsumer {
    @Autowired private PagamentoFacade pagamentoFacade;

    @RabbitListener(queues = { "pagamento-response-erro-queue" })
    public void receive(@Payload Message message) {
        System.out.println("Mensagem " + message + " " + LocalDateTime.now());
        String payload = String.valueOf(message.getPayload());

        pagamentoFacade.erroPagamento(payload);
    }
}
