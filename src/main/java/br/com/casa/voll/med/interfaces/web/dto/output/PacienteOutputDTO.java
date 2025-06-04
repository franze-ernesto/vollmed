package br.com.casa.voll.med.interfaces.web.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteOutputDTO {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
}
