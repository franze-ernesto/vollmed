package br.com.casa.voll.med.interfaces.web.dto.input;

import br.com.casa.voll.med.domain.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoInputDTO {
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
        private String nome;

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato de e-mail inválido")
        private String email;

        @NotBlank(message = "Telefone é obrigatório")
        @Pattern(regexp = "\\d{10,11}", message = "CRM deve conter entre 10 e 11 dígitos numéricos")
        private String telefone;

        @NotBlank(message = "CRM é obrigatório")
        @Pattern(regexp = "\\d{4,6}", message = "CRM deve conter entre 4 e 6 dígitos numéricos")
        private String crm;

        @NotNull(message = "Especialidade é obrigatória")
        private Especialidade especialidade;

        @NotNull(message = "Endereço é obrigatório")
        @Valid
        private DadosEnderecoDTO endereco;
}
