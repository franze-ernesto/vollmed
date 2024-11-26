package br.com.casa.voll.med.model;

import br.com.casa.voll.med.dto.DadosAtualizacaoPaciente;
import br.com.casa.voll.med.dto.DadosEndereco;
import br.com.casa.voll.med.dto.DadosPaciente;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(DadosPaciente dadosPaciente) {
        this.ativo = true;
        this.nome = dadosPaciente.nome();
        this.email = dadosPaciente.email();
        this.telefone = dadosPaciente.telefone();
        this.cpf = dadosPaciente.cpf();
        this.endereco = new Endereco(dadosPaciente.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dadosAtualizacaoPaciente) {
        if (dadosAtualizacaoPaciente.nome() != null) {
            this.nome = dadosAtualizacaoPaciente.nome();
        }
        if (dadosAtualizacaoPaciente.telefone() != null) {
            this.telefone = dadosAtualizacaoPaciente.telefone();
        }
        if (dadosAtualizacaoPaciente.endereco() != null) {
            this.endereco.atualizarInformacoes(dadosAtualizacaoPaciente.endereco());
        }

    }

    public void excluirPaciente() {
        this.ativo = false;
    }
}
