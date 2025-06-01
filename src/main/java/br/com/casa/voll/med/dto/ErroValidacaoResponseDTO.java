package br.com.casa.voll.med.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ErroValidacaoResponseDTO(
        int status,
        String erro,
        List<String> mensagens,
        String caminho,
        LocalDateTime timestamp
) {
}
