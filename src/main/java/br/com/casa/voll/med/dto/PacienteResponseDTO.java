package br.com.casa.voll.med.dto;


public record PacienteResponseDTO (
        Long id,
        String nome,
        String email,
        String cpf
){}
