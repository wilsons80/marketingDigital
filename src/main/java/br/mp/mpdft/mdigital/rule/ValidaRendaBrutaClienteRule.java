package br.mp.mpdft.mdigital.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.excpetion.RendaBrutaMensalInvalidaException;

@Component
public class ValidaRendaBrutaClienteRule {

	public void valida(Double rendaBruta){
		if(Objects.isNull(rendaBruta)){
			throw new RendaBrutaMensalInvalidaException("A renda bruta mensal não foi informada.");
		}
		if(rendaBruta.toString().matches("^[0-9]{0,6}\\.?[0-9]{1,2}$") == Boolean.FALSE){
			throw new RendaBrutaMensalInvalidaException("O valor de renda bruta mensal não está formato válido (999999,99) - Valor informado:" + rendaBruta);
		}
	}
}
