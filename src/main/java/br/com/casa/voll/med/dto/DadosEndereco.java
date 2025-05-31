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
        @NotBlank(message = "Rua é obrigatória")
        private String rua;

        @NotBlank(message = "Número é obrigatório")
        private String numero;

        @NotBlank(message = "Completo é obrigatório")
        private String complemento;

        @NotBlank(message = "Bairro é obrigatório")
        private String bairro;

        @NotBlank(message = "Cep é obrigatório")
        @Pattern(regexp = "\\d{9}")
        private String cep;

        @NotBlank(message = "Cidade é obrigatória")
        private String cidade;

        @NotBlank(message = "UF é obrigatória")
        private String uf;

}
