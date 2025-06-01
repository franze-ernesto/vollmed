package br.com.casa.voll.med.dto;

import java.time.LocalDateTime;

public record ErroResponseDTO(
        int status,
        String erro,
        String mensagem,
        String caminho,
        LocalDateTime timestamp
) {
}
