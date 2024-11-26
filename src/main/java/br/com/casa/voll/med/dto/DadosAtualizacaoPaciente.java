package br.com.casa.voll.med.dto;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
