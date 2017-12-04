package br.mp.mpdft.mdigital.rule;

import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.excpetion.TelefoneClienteInvalidoException;

@Component
public class ValidaTelefoneClienteRule {

	public void valida(String telefone){
		if(telefone.matches("^[0-9]{0,9}$") == Boolean.FALSE){
			throw new TelefoneClienteInvalidoException("O Telefone deve conter ter no máximo 9 dígitos numéricos no formado: 999999999");
		}
	}
}
