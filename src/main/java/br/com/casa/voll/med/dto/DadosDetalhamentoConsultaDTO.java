package br.com.casa.voll.med.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosDetalhamentoConsultaDTO {
    private Long id;
    private Long idMedico;
    private String nomeMedico;
    private Long idPaciente;
    private LocalDateTime data;
}
