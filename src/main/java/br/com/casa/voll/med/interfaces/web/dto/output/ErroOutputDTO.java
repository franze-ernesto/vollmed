package br.com.casa.voll.med.interfaces.web.dto.output;

import java.time.LocalDateTime;

public record ErroOutputDTO(
        int status,
        String erro,
        String mensagem,
        String caminho,
        LocalDateTime timestamp
) {
}
