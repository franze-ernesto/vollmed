package br.com.casa.voll.med.dto;

import br.com.casa.voll.med.model.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosMedico {
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
        private String nome;

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato de e-mail inválido")
        private String email;

        @NotBlank(message = "Telefone é obrigatório")
        @Pattern(regexp = "\\d{10,11}")
        private String telefone;

        @NotBlank(message = "CRM é obrigatório")
        @Pattern(regexp = "\\d{4,6}")
        private String crm;

        @NotNull(message = "Especialidade é obrigatória")
        private Especialidade especialidade;

        @NotNull(message = "Endereço é obrigatório")
        @Valid
        private DadosEndereco endereco;
}
