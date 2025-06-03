package br.com.casa.voll.med.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
}
