package br.com.fiap.sb_kafka_consumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PagamentoConsumer {
    @KafkaListener(topics = "${kafka.topic.pagamento}", groupId = "grupo-pagamentos")
    public void consumir(String mensagem) {
        System.out.println("Mensagem: " + mensagem);
    }
}
