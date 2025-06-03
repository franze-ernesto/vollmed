package br.com.casa.voll.med.repository;

import br.com.casa.voll.med.enums.Especialidade;
import br.com.casa.voll.med.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.nio.channels.FileChannel;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable pageable);

    Optional<Medico> findByIdAndAtivoTrue(Long id);

    @Query(""" 
        SELECT m FROM Medico m
        WHERE m.ativo = TRUE
        AND 
        m.especialidade = :especialidade
        AND NOT EXISTS (
            SELECT c FROM Consulta c
            WHERE c.medico = m AND c.data = :data            
        )
        
        
""")
    List<Medico> escolherMedicoDisponivel(@Param("especialidade") Especialidade especialidade,
                                          @Param("data") LocalDateTime data,
                                          Pageable pageable);
}
