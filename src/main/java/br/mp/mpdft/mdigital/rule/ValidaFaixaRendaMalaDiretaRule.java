package br.mp.mpdft.mdigital.rule;

import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.excpetion.RendaBrutaMensalInvalidaException;

@Component
public class ValidaFaixaRendaMalaDiretaRule {
	public void valida(Double faixaRendaInicial, Double faixaRendaFinal){
		
		if(faixaRendaInicial > faixaRendaFinal){
			throw new RendaBrutaMensalInvalidaException("A Faixa de Renda Inicial n�o pode ser maior que a Faixa de Renda Final.");
		}
	}
}
