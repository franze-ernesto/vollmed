package br.com.casa.voll.med.controller;

import br.com.casa.voll.med.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping

    @GetMapping("/{id}")

    @PostMapping

    @PutMapping("/{id}")

    @PatchMapping("/{id}")

    @DeleteMapping("/{id}")

}

