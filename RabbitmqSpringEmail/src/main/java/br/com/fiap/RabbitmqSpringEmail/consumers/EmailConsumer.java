package br.com.fiap.RabbitmqSpringEmail.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.fiap.RabbitmqSpringEmail.dtos.EmailDto;
import br.com.fiap.RabbitmqSpringEmail.models.EmailModel;
import br.com.fiap.RabbitmqSpringEmail.services.EmailService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmailConsumer {
    EmailService emailService;

    @RabbitListener(queues = "ms.email")
    public void listen(@Payload EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);

        System.out.println("Email Staus: " + emailModel.getStatusEmail().toString());
    }
}
