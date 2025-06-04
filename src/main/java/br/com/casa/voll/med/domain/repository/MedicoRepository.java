package br.com.casa.voll.med.domain.repository;

import br.com.casa.voll.med.domain.enums.Especialidade;
import br.com.casa.voll.med.domain.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
            AND 
            m.id not in(
                select c.medico.id from Consulta c
                where 
                c.data = :data
            ) 
            ORDER BY RAND()
            LIMIT 1 
        
        
            """)
    List<Medico> escolherMedicoDisponivel(@Param("especialidade") Especialidade especialidade,
                                          @Param("data") LocalDateTime data,
                                          Pageable pageable);

    @Query("""
            select m.ativo
            from Medico m
            where
            m.id = :id
            """)

    Boolean findAtivoById(Long id);
}
