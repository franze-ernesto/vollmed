package br.com.casa.voll.med.domain.service.validation;

import br.com.casa.voll.med.interfaces.web.dto.input.DadosAgendamentoConsultaDTO;

public interface ValidadorAgendamentoConsultas {
    void validar (DadosAgendamentoConsultaDTO dados);
}
