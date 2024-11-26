package br.com.casa.voll.med.controller;

import br.com.casa.voll.med.dto.DadosAtualizacaoPaciente;
import br.com.casa.voll.med.dto.DadosListagemPaciente;
import br.com.casa.voll.med.dto.DadosPaciente;
import br.com.casa.voll.med.model.Paciente;
import br.com.casa.voll.med.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosPaciente dadosPaciente) {
        pacienteRepository.save(new Paciente(dadosPaciente));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return pacienteRepository.findAllByAtivoTrue(pageable)
                .map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoPaciente dadosAtualizacaoPaciente) {
        var paciente = pacienteRepository.getReferenceById(dadosAtualizacaoPaciente.id());
        paciente.atualizarInformacoes(dadosAtualizacaoPaciente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluirPaciente();

    }



}
