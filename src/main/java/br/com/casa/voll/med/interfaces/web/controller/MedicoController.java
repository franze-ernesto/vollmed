package br.com.casa.voll.med.interfaces.web.controller;

import br.com.casa.voll.med.interfaces.web.dto.input.MedicoInputDTO;
import br.com.casa.voll.med.interfaces.web.dto.output.MedicoOutputDTO;
import br.com.casa.voll.med.application.service.MedicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<MedicoOutputDTO> salvar(@RequestBody @Valid MedicoInputDTO medicoInputDTO, UriComponentsBuilder uriBuilder) {
        MedicoOutputDTO medicoCadastrado = medicoService.cadastrarMedico(medicoInputDTO);

        var uri = uriBuilder.path("/medicos/{id}")
                .buildAndExpand(medicoCadastrado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(medicoCadastrado);
    }

    @GetMapping
    public ResponseEntity<Page<MedicoOutputDTO>> listar(@PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        return ResponseEntity.ok(medicoService.listarTodosMedicos(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<MedicoOutputDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.buscarMedicoPorId(id));
    }

    @PutMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<MedicoOutputDTO> atualizar(@PathVariable Long id, @RequestBody @Valid MedicoInputDTO medicoInputDTO) {
        return ResponseEntity.ok(medicoService.atualizarMedico(id, medicoInputDTO));
    }

    @PatchMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<MedicoOutputDTO> atualizarParcial(@PathVariable Long id, @RequestBody @Valid MedicoInputDTO medicoInputDTO) {
        return ResponseEntity.ok(medicoService.atualizarParcial(id, medicoInputDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }


}