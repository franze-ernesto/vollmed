package br.com.casa.voll.med.dto;

import br.com.casa.voll.med.model.Paciente;

public record DadosListagemPaciente(
        Long id,
        String nome,
        String email,
        String cpf
) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());

    }
}
