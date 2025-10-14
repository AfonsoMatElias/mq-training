package br.com.fiap.RabbitmqSpringEmail.dtos;

import java.time.LocalDateTime;

import br.com.fiap.RabbitmqSpringEmail.enums.StatusEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDto {
    @NotBlank
    private String ownerRef;
    
    @Email
    @NotBlank
    private String emailFrom;

    @Email
    @NotBlank
    private String emailTo;
    
    @NotBlank
    private String subject;
    
    @NotBlank
    private String text;
    
    @NotBlank
    private LocalDateTime sendDateEmail;
    
    @NotBlank
    private StatusEnum statusEmail;
}
