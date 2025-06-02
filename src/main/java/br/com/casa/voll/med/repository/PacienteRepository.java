package br.com.casa.voll.med.repository;

import br.com.casa.voll.med.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
