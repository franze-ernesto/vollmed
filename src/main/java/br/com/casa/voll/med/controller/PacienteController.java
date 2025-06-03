package br.com.casa.voll.med.controller;

import br.com.casa.voll.med.dto.PacienteRequestDTO;
import br.com.casa.voll.med.dto.PacienteResponseDTO;
import br.com.casa.voll.med.model.Paciente;
import br.com.casa.voll.med.repository.PacienteRepository;
import br.com.casa.voll.med.service.MedicoService;
import br.com.casa.voll.med.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoService medicoService;


    @GetMapping
    public ResponseEntity<Page<PacienteResponseDTO>> listar(@PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        return ResponseEntity.ok(pacienteService.listarTodosPacientes(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.listarPacientesPorId(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PacienteResponseDTO> cadastrar(@RequestBody PacienteRequestDTO dto, UriComponentsBuilder uriBuilder) {
        PacienteResponseDTO pacienteCadastrado = pacienteService.cadastrarPacientes(dto);

        var uri = uriBuilder.path("pacientes/{id}")
                .buildAndExpand(pacienteCadastrado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(pacienteCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizarTotal(@PathVariable Long id, @RequestBody PacienteRequestDTO dto) {
        return ResponseEntity.ok(pacienteService.atualizarPacientesTotal(id,dto));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizarParcial(@PathVariable Long id, @RequestBody PacienteRequestDTO dto) {
        return ResponseEntity.ok(pacienteService.atualizarPacientesParcial(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }


}

