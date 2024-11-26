package br.com.casa.voll.med.dto;

import br.com.casa.voll.med.model.Especialidade;
import br.com.casa.voll.med.model.Medico;

public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
