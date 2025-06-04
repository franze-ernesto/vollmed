package br.com.casa.voll.med.interfaces.web.dto.output;

import br.com.casa.voll.med.domain.enums.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoOutputDTO {
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private Especialidade especialidade;
}
