package br.com.casa.voll.med.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosAgendamentoConsultaDTO {
    @NotNull
    private Long idPaciente;

    private Long idMedico;

    @NotNull
    @Future
    private LocalDateTime data;
}
