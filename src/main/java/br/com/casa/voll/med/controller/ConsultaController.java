package br.com.casa.voll.med.controller;

import br.com.casa.voll.med.dto.DadosAgendConsResponseDTO;
import br.com.casa.voll.med.dto.DadosAgendamentoConsultaDTO;
import br.com.casa.voll.med.dto.DadosDetalhamentoConsultaDTO;
import br.com.casa.voll.med.service.ConsultaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;


    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoConsultaDTO>> agendar(@PageableDefault(size = 10, sort = "data") Pageable pageable) {
        return ResponseEntity.ok(consultaService.consultar(pageable));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosAgendConsResponseDTO> cadastrarConsulta(@RequestBody DadosAgendamentoConsultaDTO dados, UriComponentsBuilder uriBuilder) {
        DadosAgendConsResponseDTO consultaCadastrada = consultaService.cadastrarConsulta(dados);
        var uri = uriBuilder.path("/consultas/{id}")
                .buildAndExpand(consultaCadastrada.getId())
                .toUri();

        return ResponseEntity.created(uri).body(consultaCadastrada);
    }



}
