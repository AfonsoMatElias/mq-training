package br.com.fiap.sb_kafka_consumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class PagamentoConsumer {
    private final SimpMessagingTemplate messagingTemplate;

    public PagamentoConsumer(
            SimpMessagingTemplate messagingTemplate
    ) {
        this.messagingTemplate = messagingTemplate;
    }

    @KafkaListener(topics = "${kafka.topic.pagamento}", groupId = "grupo-pagamentos")
    public void consumir(String mensagem) {
        System.out.println("Mensagem: " + mensagem);
        messagingTemplate.convertAndSend("/topic/messages", mensagem);
    }
}
