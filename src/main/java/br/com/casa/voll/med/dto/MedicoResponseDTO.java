package br.com.casa.voll.med.dto;

import br.com.casa.voll.med.enums.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoResponseDTO {
    private Long id;
    private String nome;
    private String crm;
    private Especialidade especialidade;

}
