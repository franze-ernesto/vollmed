package br.com.casa.voll.med.interfaces.web.dto.output;

public record UsuarioOutputDTO(
        Long id,
        String login,
        String senha
) {}
