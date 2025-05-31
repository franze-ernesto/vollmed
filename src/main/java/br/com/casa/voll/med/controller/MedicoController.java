package br.com.casa.voll.med.controller;

import br.com.casa.voll.med.dto.MedicoRequestDTO;
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


    @GetMapping("/{id}")


    @PutMapping("/{id}")


    @DeleteMapping("/{id}")


}