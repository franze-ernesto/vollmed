package br.com.casa.voll.med.service;

import br.com.casa.voll.med.dto.MedicoRequestDTO;
import br.com.casa.voll.med.dto.MedicoResponseDTO;
import br.com.casa.voll.med.model.Medico;
import br.com.casa.voll.med.repository.MedicoRepository;
import br.com.casa.voll.med.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ModelMapper modelMapper;

    //listarTodos()
    public List<MedicoResponseDTO> listarTodosMedicos() {
        return medicoRepository.findAll()
                .stream()
                .map(m -> modelMapper.map(m, MedicoResponseDTO.class))
                .collect(Collectors.toList());
    }

    //listarPorId()
    public MedicoResponseDTO buscarMedicoPorId(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Médico não encontrado com o id: " + id));
        return modelMapper.map(medico, MedicoResponseDTO.class);
    }

    //cadastrar()
    public MedicoResponseDTO cadastrarMedico(MedicoRequestDTO dto) {
        Medico medico = modelMapper.map(dto, Medico.class);
        Medico medicoSalvo = medicoRepository.save(medico);

        return modelMapper.map(medicoSalvo, MedicoResponseDTO.class);
    }

    //atualizarMedico()
    public MedicoResponseDTO atualizarMedico(Long id, MedicoRequestDTO dto) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Médico não encontrado com o id: " + id));
        Medico medicoAtualizado = medicoRepository.save(medico);

        return modelMapper.map(medicoAtualizado, MedicoResponseDTO.class);
    }

    //deletarMedico()
    public void deletarMedico(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Médico não encontrado com o id: " + id));
        medico.setAtivo(false);
        medicoRepository.delete(medico);
    }


}
