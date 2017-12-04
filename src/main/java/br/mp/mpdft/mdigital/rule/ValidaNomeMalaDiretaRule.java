package br.mp.mpdft.mdigital.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.excpetion.NomeNaoInformadoException;

@Component
public class ValidaNomeMalaDiretaRule {

	public void valida(String nome){
		if(Objects.isNull(nome)){
			throw new NomeNaoInformadoException("O nome da Mala Direta � obrigat�rio.");
		}
		
		if(nome.length() > 250){
			throw new NomeNaoInformadoException("O nome da Mala Direta deve ter no m�ximo 250 caracteres.");
		}
	}
}
