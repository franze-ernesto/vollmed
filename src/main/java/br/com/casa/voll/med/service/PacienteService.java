package br.com.casa.voll.med.service;

import br.com.casa.voll.med.dto.DadosEnderecoDTO;
import br.com.casa.voll.med.dto.PacienteRequestDTO;
import br.com.casa.voll.med.dto.PacienteResponseDTO;
import br.com.casa.voll.med.exception.ObjectNotFoundException;
import br.com.casa.voll.med.model.Endereco;
import br.com.casa.voll.med.model.Paciente;
import br.com.casa.voll.med.repository.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PacienteResponseDTO> listarTodosPacientes(Pageable pageable) {
        return pacienteRepository.findAll(pageable)
                .map(x -> modelMapper.map(x, PacienteResponseDTO.class));
    }

    public PacienteResponseDTO listarPacientesPorId(Long id) {
        Paciente paciente = pacienteRepository.getOne(id);
        return modelMapper.map(paciente, PacienteResponseDTO.class);
    }

    @Transactional
    public PacienteResponseDTO cadastrarPacientes(PacienteRequestDTO dto) {
        Paciente paciente = modelMapper.map(dto, Paciente.class);
        Paciente pacienteCadastrado = pacienteRepository.save(paciente);

        return modelMapper.map(pacienteCadastrado, PacienteResponseDTO.class);

    }


    public PacienteResponseDTO atualizarPacientesTotal(Long id, PacienteRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado com o id: " + id));
        Paciente pacienteAtualizado = pacienteRepository.save(paciente);

        return modelMapper.map(pacienteAtualizado, PacienteResponseDTO.class);
    }


    public PacienteResponseDTO atualizarPacientesParcial(Long id, PacienteRequestDTO dto) {
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

        return modelMapper.map(pacienteAtualizadoParcial, PacienteResponseDTO.class);

    }


    public void excluirPaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado com o id: " + id));
        paciente.setAtivo(false);
        modelMapper.map(paciente, Paciente.class);

    }
}
