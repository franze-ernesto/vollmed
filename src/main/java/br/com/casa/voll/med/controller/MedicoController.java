package br.com.casa.voll.med.controller;

import br.com.casa.voll.med.dto.MedicoRequestDTO;
import br.com.casa.voll.med.dto.MedicoResponseDTO;
import br.com.casa.voll.med.model.Medico;
import br.com.casa.voll.med.repository.MedicoRepository;
import br.com.casa.voll.med.service.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;


    @PostMapping
    @Transactional
    public ResponseEntity<MedicoResponseDTO> salvar(@RequestBody @Valid MedicoRequestDTO medicoRequestDTO, UriComponentsBuilder uriBuilder) {
        MedicoResponseDTO medicoCadastrado = medicoService.cadastrarMedico(medicoRequestDTO);

        var uri = uriBuilder.path("/medicos/{id}")
                .buildAndExpand(medicoCadastrado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(medicoCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> listar() {
        return ResponseEntity.ok(medicoService.listarTodosMedicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.buscarMedicoPorId(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<MedicoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid MedicoRequestDTO medicoRequestDTO) {
        return ResponseEntity.ok(medicoService.atualizarMedico(id, medicoRequestDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<MedicoResponseDTO> atualizarParcial(@PathVariable Long id, @RequestBody @Valid MedicoRequestDTO medicoRequestDTO) {
        return ResponseEntity.ok(medicoService.atualizarParcial(id, medicoRequestDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }


}