package br.com.casa.voll.med.controller;

import br.com.casa.voll.med.dto.DadosMedico;
import br.com.casa.voll.med.model.Medico;
import br.com.casa.voll.med.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosMedico dadosMedico) {
        medicoRepository.save(new Medico(dadosMedico));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size=10, sort = {"nome"}) Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable)
                .map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dadosMedico) {
        var medico = medicoRepository.getReferenceById(dadosMedico.id());
        medico.atualizarInformacoes(dadosMedico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluirMedico();

    }

}