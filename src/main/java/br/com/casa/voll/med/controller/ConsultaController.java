package br.com.casa.voll.med.controller;

import br.com.casa.voll.med.dto.DadosAgendamentoConsultaDTO;
import br.com.casa.voll.med.dto.DadosDetalhamentoConsultaDTO;
import br.com.casa.voll.med.service.ConsultaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;


    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConsultaDTO> agendar(@RequestBody DadosAgendamentoConsultaDTO agendamento) {
        return ResponseEntity.ok();

    }


}
