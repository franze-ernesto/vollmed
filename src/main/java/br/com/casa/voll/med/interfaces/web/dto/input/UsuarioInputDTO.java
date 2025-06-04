package br.com.casa.voll.med.interfaces.web.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioInputDTO {
    private String login;
    private String senha;
}
