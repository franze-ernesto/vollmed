package br.com.casa.voll.med.interfaces.web.dto.output;

import java.time.LocalDateTime;
import java.util.List;

public record ErroValidacaoOutputDTO(
        int status,
        String erro,
        List<String> mensagens,
        String caminho,
        LocalDateTime timestamp
) {
}
