package br.com.fiap.RabbitmqSpringEmail.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.fiap.RabbitmqSpringEmail.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEnum statusEmail;
}
