package br.com.casa.voll.med.domain.service.validation;

import br.com.casa.voll.med.interfaces.web.dto.input.DadosAgendamentoConsultaDTO;
import br.com.casa.voll.med.application.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorFuncioClinica implements ValidadorAgendamentoConsultas{
    public void validar (DadosAgendamentoConsultaDTO dados) {
        var dadosConsulta = dados.getData();

        var domingo = dadosConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesAberClinica = dadosConsulta.getHour() < 7;
        var depoisFechClinica= dadosConsulta.getHour() > 18;
        if (domingo || antesAberClinica || depoisFechClinica) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento");
        }

    }
}
