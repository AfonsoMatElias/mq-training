package br.com.fiap.RabbitmqSpringEmail.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.fiap.RabbitmqSpringEmail.enums.StatusEnum;
import br.com.fiap.RabbitmqSpringEmail.models.EmailModel;
import br.com.fiap.RabbitmqSpringEmail.repositories.EmailRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

    private EmailRepository repository;

    private JavaMailSender javaMailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());            

            javaMailSender.send(message);

            emailModel.setStatusEmail(StatusEnum.SENT);
        } catch (Exception e) {
            emailModel.setStatusEmail(StatusEnum.ERROR);
        }

        return repository.save(emailModel);
    }

    public Page<EmailModel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<EmailModel> findById(UUID emailId) {
        return repository.findById(emailId);
    }
}
