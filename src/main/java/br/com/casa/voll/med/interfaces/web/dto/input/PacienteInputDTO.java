package br.com.casa.voll.med.interfaces.web.dto.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteInputDTO {
    @NotBlank(message = "Nome não pode ser nulo")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Email não pode ser nulo")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @NotBlank(message = "Telefone não pode ser nulo")
    @Pattern(regexp = "\\d{10,11}", message = "CRM deve conter entre 10 e 11 dígitos numéricos")
    private String telefone;

    @NotBlank(message = "Cpf não pode ser nulo")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    private String cpf;

    @NotNull(message = "Endereço é obrigatório")
    @Valid
    private DadosEnderecoDTO endereco;
}
