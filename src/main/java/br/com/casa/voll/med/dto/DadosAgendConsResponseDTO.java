package br.com.casa.voll.med.dto;

import br.com.casa.voll.med.enums.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosAgendConsResponseDTO {
    private Long id;
    private Long idPaciente;
    private Long idMedico;
    private LocalDateTime data;

}
