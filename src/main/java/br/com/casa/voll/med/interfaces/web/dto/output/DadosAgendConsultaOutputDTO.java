package br.com.casa.voll.med.interfaces.web.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosAgendConsultaOutputDTO {
    private Long id;
    private Long idPaciente;
    private Long idMedico;
    private LocalDateTime data;

}
