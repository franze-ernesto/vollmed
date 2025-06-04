package br.com.casa.voll.med.domain.service.validation;

import br.com.casa.voll.med.interfaces.web.dto.input.DadosAgendamentoConsultaDTO;
import br.com.casa.voll.med.application.exception.ValidacaoException;
import br.com.casa.voll.med.domain.repository.ConsultaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoConsultas{
    @Autowired
    private ConsultaRespository consultaRespository;

    public void validar (DadosAgendamentoConsultaDTO dados) {
        var medicoPossuiOutraConsultaMesmoHorario = consultaRespository.existsByMedicoIdAndData(dados.getIdMedico(), dados.getData());
        if (medicoPossuiOutraConsultaMesmoHorario) {
            throw new ValidacaoException("Médico já posssuí outra consulta agendada nesse mesmo horário");
        }


    }
}
