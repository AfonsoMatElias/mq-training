package br.com.fiap.RabbitmqSpringEmail.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.RabbitmqSpringEmail.models.EmailModel;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
}
