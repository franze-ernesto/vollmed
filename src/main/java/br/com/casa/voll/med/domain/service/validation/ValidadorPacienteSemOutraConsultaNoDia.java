package br.com.casa.voll.med.domain.service.validation;

import br.com.casa.voll.med.interfaces.web.dto.input.DadosAgendamentoConsultaDTO;
import br.com.casa.voll.med.application.exception.ValidacaoException;
import br.com.casa.voll.med.domain.repository.ConsultaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoConsultas{
    @Autowired
    private ConsultaRespository consultaRespository;

    public void validar DadosAgendamentoConsultaDTO dados) {
        var primeiroHorario = dados.getData().withHour(7);
        var ultimoHorario = dados.getData().withHour(18);

        var pacientePossuiOutraConsultaNoDia = consultaRespository.existsByPacienteIdAndDateBetween(dados.getIdPaciente(), primeiroHorario, ultimoHorario);
        if (pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoException("Paciente já possui consulta agendada nesse dia");
        }
    }


}
