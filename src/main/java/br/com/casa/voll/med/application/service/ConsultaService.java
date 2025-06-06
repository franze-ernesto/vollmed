package br.com.casa.voll.med.application.service;

import br.com.casa.voll.med.interfaces.web.dto.output.DadosAgendConsultaOutputDTO;
import br.com.casa.voll.med.interfaces.web.dto.input.DadosAgendamentoConsultaDTO;
import br.com.casa.voll.med.interfaces.web.dto.output.DadosDetalhamentoConsultaDTO;
import br.com.casa.voll.med.application.exception.ValidacaoException;
import br.com.casa.voll.med.domain.model.Consulta;
import br.com.casa.voll.med.domain.service.validation.ValidadorAgendamentoConsultas;
import br.com.casa.voll.med.domain.repository.ConsultaRespository;
import br.com.casa.voll.med.domain.repository.MedicoRepository;
import br.com.casa.voll.med.domain.repository.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private ConsultaRespository consultaRespository;
    private MedicoRepository medicoRepository;
    private PacienteRepository pacienteRepository;
    private ModelMapper modelMapper;

    public ConsultaService(ConsultaRespository consultaRespository, MedicoRepository medicoRepository, PacienteRepository pacienteRepository, ModelMapper modelMapper, List<ValidadorAgendamentoConsultas> validadores) {
        this.consultaRespository = consultaRespository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
        this.validadores = validadores;
    }

    private List<ValidadorAgendamentoConsultas> validadores;

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
    public DadosAgendConsultaOutputDTO cadastrarConsulta(DadosAgendamentoConsultaDTO agendamentoDTO) {
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

        validadores.forEach(v -> v.validar(agendamentoDTO));

        var consulta = new Consulta();
        consulta.setMedico(medicoDisponiveis.get(0));
        consulta.setPaciente(pacienteOptional.get());
        consulta.setData(agendamentoDTO.getData());

        var consultaSalva = consultaRespository.save(consulta);

        return modelMapper.map(consultaSalva, DadosAgendConsultaOutputDTO.class);
    }

}
