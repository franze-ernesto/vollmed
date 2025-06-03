package br.com.casa.voll.med.service;

import br.com.casa.voll.med.dto.DadosAgendConsResponseDTO;
import br.com.casa.voll.med.dto.DadosAgendamentoConsultaDTO;
import br.com.casa.voll.med.dto.DadosDetalhamentoConsultaDTO;
import br.com.casa.voll.med.model.Consulta;
import br.com.casa.voll.med.repository.ConsultaRespository;
import br.com.casa.voll.med.repository.MedicoRepository;
import br.com.casa.voll.med.repository.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRespository consultaRespository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper modelMapper;




    //consultarAgendamento()
    public Page<DadosDetalhamentoConsultaDTO> consultar(Pageable pageable) {
        return consultaRespository.findAll(pageable)
                .map(c -> modelMapper.map(c, DadosDetalhamentoConsultaDTO.class));
    }

    //agendar()
    public DadosAgendConsResponseDTO cadastrarConsulta(DadosAgendamentoConsultaDTO agendamentoDTO) {
        var medico = medicoRepository.getReferenceById(agendamentoDTO.getIdMedico());
        var paciente = pacienteRepository.getReferenceById(agendamentoDTO.getIdPaciente());

        var consulta = new Consulta();
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setData(agendamentoDTO.getData());

        var consultaSalva = consultaRespository.save(consulta);

        return modelMapper.map(consultaSalva, DadosAgendConsResponseDTO.class);
    }
}
