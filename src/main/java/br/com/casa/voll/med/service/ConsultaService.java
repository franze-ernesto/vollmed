package br.com.casa.voll.med.service;

import br.com.casa.voll.med.repository.ConsultaRespository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRespository consultaRespository;

    @Autowired
    private ModelMapper modelMapper;

    //agendar()

    //consultarAgendamento()
}
