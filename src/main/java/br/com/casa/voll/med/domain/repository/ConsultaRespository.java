package br.com.casa.voll.med.domain.repository;

import br.com.casa.voll.med.domain.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRespository extends JpaRepository<Consulta, Long> {
    Object existsByMedicoIdAndData(Long idMedico, LocalDateTime data);

    Object existsByPacienteIdAndDateBetween(Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
