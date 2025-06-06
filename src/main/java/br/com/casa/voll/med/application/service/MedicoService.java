package br.com.casa.voll.med.application.service;

import br.com.casa.voll.med.application.exception.ObjectNotFoundException;
import br.com.casa.voll.med.domain.model.Medico;
import br.com.casa.voll.med.domain.repository.MedicoRepository;
import br.com.casa.voll.med.interfaces.web.dto.input.MedicoInputDTO;
import br.com.casa.voll.med.interfaces.web.dto.output.MedicoOutputDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;


    private final ModelMapper modelMapper;

    //listarTodos()
    public Page<MedicoOutputDTO> listarTodosMedicos(Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable)
                .map(m -> modelMapper.map(m, MedicoOutputDTO.class));
    }

    public MedicoService(MedicoRepository medicoRepository, ModelMapper modelMapper) {
        this.medicoRepository = medicoRepository;
        this.modelMapper = modelMapper;
    }

    //listarPorId()
    public MedicoOutputDTO buscarMedicoPorId(Long id) {
        Medico medico = medicoRepository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new ObjectNotFoundException("Médico não encontrado ou inativo com o id: " + id));
        return modelMapper.map(medico, MedicoOutputDTO.class);
    }

    //cadastrar()
    @Transactional
    public MedicoOutputDTO cadastrarMedico(MedicoInputDTO dto) {
        Medico medico = modelMapper.map(dto, Medico.class);
        Medico medicoSalvo = medicoRepository.save(medico);

        return modelMapper.map(medicoSalvo, MedicoOutputDTO.class);
    }

    //atualizarMedico()
    @Transactional
    public MedicoOutputDTO atualizarMedico(Long id, MedicoInputDTO dto) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Médico não encontrado com o id: " + id));
        Medico medicoAtualizado = medicoRepository.save(medico);

        return modelMapper.map(medicoAtualizado, MedicoOutputDTO.class);
    }

    //atualizarParcialMedico()
    @Transactional
    public MedicoOutputDTO atualizarParcial(Long id, MedicoInputDTO dto) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Médico não encontrado com o id: " + id));
        if (dto.getNome() != null) {medico.setNome(dto.getNome());}
        if (dto.getEmail() != null) {medico.setEmail(dto.getEmail());}
        if (dto.getCrm() != null) {medico.setCrm(dto.getCrm());}
        if (dto.getEspecialidade() != null) {medico.setEspecialidade(dto.getEspecialidade());}

        Medico medicoAtualizado = medicoRepository.save(medico);
        return modelMapper.map(medicoAtualizado, MedicoOutputDTO.class);
    }


    //deletarMedico()
    @Transactional
    public void deletarMedico(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Médico não encontrado com o id: " + id));
        medico.setAtivo(false);
        medicoRepository.save(medico);
    }


}
