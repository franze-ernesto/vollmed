package br.com.casa.voll.med.application.service;

import br.com.casa.voll.med.interfaces.web.dto.input.DadosEnderecoDTO;
import br.com.casa.voll.med.interfaces.web.dto.input.PacienteInputDTO;
import br.com.casa.voll.med.interfaces.web.dto.output.PacienteOutputDTO;
import br.com.casa.voll.med.application.exception.ObjectNotFoundException;
import br.com.casa.voll.med.domain.model.Endereco;
import br.com.casa.voll.med.domain.model.Paciente;
import br.com.casa.voll.med.domain.repository.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;


    public PacienteService(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    public Page<PacienteOutputDTO> listarTodosPacientes(Pageable pageable) {
        return pacienteRepository.findAll(pageable)
                .map(x -> modelMapper.map(x, PacienteOutputDTO.class));
    }

    public PacienteOutputDTO listarPacientesPorId(Long id) {
        Paciente paciente = pacienteRepository.getOne(id);
        return modelMapper.map(paciente, PacienteOutputDTO.class);
    }

    @Transactional
    public PacienteOutputDTO cadastrarPacientes(PacienteInputDTO dto) {
        Paciente paciente = modelMapper.map(dto, Paciente.class);
        Paciente pacienteCadastrado = pacienteRepository.save(paciente);

        return modelMapper.map(pacienteCadastrado, PacienteOutputDTO.class);
    }

    public PacienteOutputDTO atualizarPacientesTotal(Long id, PacienteInputDTO dto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado com o id: " + id));
        Paciente pacienteAtualizado = pacienteRepository.save(paciente);

        return modelMapper.map(pacienteAtualizado, PacienteOutputDTO.class);
    }

    public PacienteOutputDTO atualizarPacientesParcial(Long id, PacienteInputDTO dto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado com o id: " + id));
        if (dto.getNome() != null) {paciente.setNome(dto.getNome());}
        if (dto.getEmail() != null) {paciente.setEmail(dto.getEmail());}

        if (dto.getEndereco() != null) {
            Endereco endereco = paciente.getEndereco();
            DadosEnderecoDTO enderecoDTO = dto.getEndereco();

            if (enderecoDTO.getRua() != null) {endereco.setRua(enderecoDTO.getRua());}
            if (enderecoDTO.getNumero() != null) {endereco.setNumero(enderecoDTO.getNumero());}
            if (enderecoDTO.getComplemento() != null) {endereco.setComplemento(enderecoDTO.getComplemento());}
            if (enderecoDTO.getBairro() != null) {endereco.setBairro(enderecoDTO.getBairro());}
            if (enderecoDTO.getCep() != null) {endereco.setCep(enderecoDTO.getCep());}
            if (enderecoDTO.getCidade() != null) {endereco.setCidade(enderecoDTO.getCidade());}
            if (enderecoDTO.getUf() != null) {endereco.setUf(enderecoDTO.getUf());}
        }

        Paciente pacienteAtualizadoParcial = pacienteRepository.save(paciente);

        return modelMapper.map(pacienteAtualizadoParcial, PacienteOutputDTO.class);
    }

    public void excluirPaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado com o id: " + id));
        paciente.setAtivo(false);
        modelMapper.map(paciente, Paciente.class);

    }
}
