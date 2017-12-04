package br.mp.mpdft.mdigital.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.excpetion.RendaBrutaMensalInvalidaException;

@Component
public class ValidaFaixaRendaInicialMalaDiretaRule {

	public void valida(Double faixa){
		if(Objects.isNull(faixa)){
			throw new RendaBrutaMensalInvalidaException("A Faixa de Renda Inicial da Mala Direta não foi informada.");
		}
		if(faixa.toString().matches("^[0-9]{0,6}\\.?[0-9]{1,2}$") == Boolean.FALSE){
			throw new RendaBrutaMensalInvalidaException("A Faixa de Renda Inicial deve conter apenas valores numéricos no formado: 999999.99 - Valor informado:" + faixa);
		}
	}
}
