package br.com.casa.voll.med.service;

import br.com.casa.voll.med.repository.MedicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ModelMapper modelMapper;

    //listarTodos()

    //listarPorId()

    //cadastrar()

    //atualizarMedico()

    //deletarMedico()


}
