package br.com.casa.voll.med.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
        String rua,
        @NotBlank
        String numero,
        @NotBlank
        String complemento,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf
) {
}
