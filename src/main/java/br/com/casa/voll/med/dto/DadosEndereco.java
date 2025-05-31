package br.com.casa.voll.med.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosEndereco {
        @NotBlank
        private String rua;

        @NotBlank
        private String numero;

        @NotBlank
        private String complemento;

        @NotBlank
        private String bairro;

        @NotBlank
        @Pattern(regexp = "\\d{9}")
        private String cep;

        @NotBlank
        private String cidade;

        @NotBlank
        private String uf;

}
