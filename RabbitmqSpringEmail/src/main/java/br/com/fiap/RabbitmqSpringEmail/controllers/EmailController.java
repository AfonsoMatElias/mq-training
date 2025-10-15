package br.com.fiap.RabbitmqSpringEmail.controllers;

import java.util.Optional;
import java.util.UUID;

import br.com.fiap.RabbitmqSpringEmail.dtos.EmailRecord;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.afonsomatelias.Configurations.ConverterConfiguration;
import io.github.afonsomatelias.IConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.RabbitmqSpringEmail.dtos.EmailDto;
import br.com.fiap.RabbitmqSpringEmail.models.EmailModel;
import br.com.fiap.RabbitmqSpringEmail.services.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
public class EmailController {
    @Autowired
    EmailService emailService;

    @PostMapping("send-email")
    public ResponseEntity<EmailModel> sendEmail(
        // @RequestBody @Valid EmailDto emailDto
        @RequestBody @Valid EmailRecord emailDto

    ) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);

        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }

    @GetMapping("/emails")
    public ResponseEntity<Page<EmailModel>> getAllEmails(
        @PageableDefault(
            page = 0, size = 5, sort = "id", direction = Direction.DESC
        ) Pageable pageable
    ) {
        return new ResponseEntity<>(emailService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/emails/{emailId}")
    public ResponseEntity<Object> getOneEmail(
        @PathVariable(value = "emailId") UUID emailId
    ) {
        Optional<EmailModel> emailModelOptional = emailService.findById(emailId);

        if (!emailModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found.");
        }
            
        return ResponseEntity.status(HttpStatus.OK).body(emailModelOptional.get());
    }
}
