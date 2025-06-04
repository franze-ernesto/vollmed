package br.com.casa.voll.med.interfaces.web.dto.input;

import br.com.casa.voll.med.domain.enums.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosAgendamentoConsultaDTO {
    private Long idMedico;

    @NotNull
    private Long idPaciente;

    @NotNull
    @Future
    private LocalDateTime data;

    private String nomeMedico;

    private Especialidade especialidade;


}
