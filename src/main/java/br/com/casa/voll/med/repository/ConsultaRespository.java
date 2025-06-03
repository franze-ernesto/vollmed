package br.com.casa.voll.med.repository;

import br.com.casa.voll.med.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRespository extends JpaRepository<Consulta, Long> {
}
