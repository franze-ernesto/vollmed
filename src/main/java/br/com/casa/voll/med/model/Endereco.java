package br.com.casa.voll.med.model;


import br.com.casa.voll.med.dto.DadosEndereco;
import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;

    public Endereco(@NotNull @Valid DadosEndereco endereco) {
        this.rua = endereco.rua();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();

    }

    public void atualizarInformacoes(DadosEndereco endereco) {
        if (endereco.rua() != null) {
            this.rua = endereco.rua();
        }
        if (endereco.numero() != null) {
            this.numero = endereco.numero();
        }
        if (endereco.complemento() != null) {
            this.complemento = endereco.complemento();
        }
        if (endereco.bairro() != null) {
            this.bairro = endereco.bairro();
        }
        if (endereco.cep() != null) {
            this.cep = endereco.cep();
        }
        if (endereco.cidade() != null) {
            this.cidade = endereco.cidade();
        }
        if (endereco.uf() != null) {
            this.uf = endereco.uf();
        }
    }
}
