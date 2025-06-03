package br.com.casa.voll.med.service;

import br.com.casa.voll.med.dto.DadosAgendConsResponseDTO;
import br.com.casa.voll.med.dto.DadosAgendamentoConsultaDTO;
import br.com.casa.voll.med.dto.DadosDetalhamentoConsultaDTO;
import br.com.casa.voll.med.exception.ValidacaoException;
import br.com.casa.voll.med.model.Consulta;
import br.com.casa.voll.med.repository.ConsultaRespository;
import br.com.casa.voll.med.repository.MedicoRepository;
import br.com.casa.voll.med.repository.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
                .map(c -> new DadosDetalhamentoConsultaDTO(
                        c.getId(),
                        c.getMedico().getId(),
                        c.getMedico().getNome(),
                        c.getPaciente().getId(),
                        c.getData()
                ));
    }

    //agendar()
    public DadosAgendConsResponseDTO cadastrarConsulta(DadosAgendamentoConsultaDTO agendamentoDTO) {
        var medicoDisponiveis = medicoRepository.escolherMedicoDisponivel(
                agendamentoDTO.getEspecialidade(),
                agendamentoDTO.getData(),
                PageRequest.of(0, 1)
        );
        if (medicoDisponiveis.isEmpty()) {
            throw new ValidacaoException("Não há médicos disponíveis nessa especialidade para o horário escolhido.");
        }


        var pacienteOptional = pacienteRepository.findByIdAndAtivoTrue(agendamentoDTO.getIdPaciente());
        if (pacienteOptional.isEmpty()) {
            throw new ValidacaoException("Paciente inativo ou não encontrado");
        }

        var consulta = new Consulta();
        consulta.setMedico(medicoDisponiveis.get(0));
        consulta.setPaciente(pacienteOptional.get());
        consulta.setData(agendamentoDTO.getData());

        var consultaSalva = consultaRespository.save(consulta);

        return modelMapper.map(consultaSalva, DadosAgendConsResponseDTO.class);
    }
}
