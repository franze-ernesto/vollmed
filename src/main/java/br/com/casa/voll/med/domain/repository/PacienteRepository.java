package br.com.casa.voll.med.domain.repository;

import br.com.casa.voll.med.domain.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable pageable);

    Optional<Paciente> findByIdAndAtivoTrue(Long id);

    Optional<Paciente> existsById(long id);

    Boolean findAtivoById(Long idPaciente);
}
