package br.com.casa.voll.med.interfaces.web.controller;

import br.com.casa.voll.med.interfaces.web.dto.input.PacienteInputDTO;
import br.com.casa.voll.med.interfaces.web.dto.output.PacienteOutputDTO;
import br.com.casa.voll.med.domain.repository.PacienteRepository;
import br.com.casa.voll.med.application.service.MedicoService;
import br.com.casa.voll.med.application.service.PacienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    private final PacienteService pacienteService;
    private final PacienteRepository pacienteRepository;
    private final MedicoService medicoService;


    public PacienteController(PacienteService pacienteService, PacienteRepository pacienteRepository, MedicoService medicoService) {
        this.pacienteService = pacienteService;
        this.pacienteRepository = pacienteRepository;
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<Page<PacienteOutputDTO>> listar(@PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        return ResponseEntity.ok(pacienteService.listarTodosPacientes(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteOutputDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.listarPacientesPorId(id));
    }

    @PostMapping
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PacienteOutputDTO> cadastrar(@RequestBody PacienteInputDTO dto, UriComponentsBuilder uriBuilder) {
        PacienteOutputDTO pacienteCadastrado = pacienteService.cadastrarPacientes(dto);

        var uri = uriBuilder.path("pacientes/{id}")
                .buildAndExpand(pacienteCadastrado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(pacienteCadastrado);
    }

    @PutMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PacienteOutputDTO> atualizarTotal(@PathVariable Long id, @RequestBody PacienteInputDTO dto) {
        return ResponseEntity.ok(pacienteService.atualizarPacientesTotal(id,dto));
    }


    @PatchMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PacienteOutputDTO> atualizarParcial(@PathVariable Long id, @RequestBody PacienteInputDTO dto) {
        return ResponseEntity.ok(pacienteService.atualizarPacientesParcial(id, dto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }


}

