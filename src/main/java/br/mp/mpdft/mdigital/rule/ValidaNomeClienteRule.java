package br.mp.mpdft.mdigital.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.excpetion.NomeNaoInformadoException;

@Component
public class ValidaNomeClienteRule {

	public void valida(String nome){
		if(Objects.isNull(nome)){
			throw new NomeNaoInformadoException("O nome do cliente n�o foi informado.");
		}
		
		if(nome.length() > 250){
			throw new NomeNaoInformadoException("O nome do cliente deve ter no m�ximo 250 caracteres.");
		}
	}
}
