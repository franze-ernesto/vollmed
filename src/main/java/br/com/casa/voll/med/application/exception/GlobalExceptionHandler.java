package br.com.casa.voll.med.application.exception;

import br.com.casa.voll.med.interfaces.web.dto.output.ErroOutputDTO;
import br.com.casa.voll.med.interfaces.web.dto.output.ErroValidacaoOutputDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroOutputDTO> tratarErro404 (EntityNotFoundException e, HttpServletRequest request) {
        var erro = new ErroOutputDTO(
                HttpStatus.NOT_FOUND.value(),
                "Médico não encontrado",
                e.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroValidacaoOutputDTO> tratarErro400 (MethodArgumentNotValidException e, HttpServletRequest request) {
        List<String> mensagens = e.getBindingResult().getFieldErrors()
                .stream()
                .map(err -> err.getDefaultMessage())
                .toList();

        var erro = new ErroValidacaoOutputDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de inclusão de dados",
                mensagens,
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
