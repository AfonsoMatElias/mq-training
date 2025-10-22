package br.com.fiap.sb_kafka_producer.producer;

import br.com.fiap.sb_kafka_producer.dto.PagamentoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PagamentoProducer {
    @Value("${topicos.pagamento.request.topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    public PagamentoProducer(
            KafkaTemplate<String, String> kafkaTemplate,
            ObjectMapper objectMapper
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String enviar(PagamentoDto pagamentoDto) throws JsonProcessingException {
        String mensagem = objectMapper.writeValueAsString(pagamentoDto);
        kafkaTemplate.send(topic, mensagem);
        return "Pagamento enviado para o Kafka!";
    }
}
