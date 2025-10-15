package br.com.fiap.RabbitmqSpringEmail.dtos;

import java.time.LocalDateTime;

import br.com.fiap.RabbitmqSpringEmail.enums.StatusEnum;

public record EmailRecord (
    String ownerRef,
    String emailFrom,
    String emailTo,
    String subject,
    String text,
    LocalDateTime sendDateEmail,
    StatusEnum statusEmail
) { }
