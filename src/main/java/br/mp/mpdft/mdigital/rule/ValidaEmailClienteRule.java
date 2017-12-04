package br.mp.mpdft.mdigital.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.excpetion.EmailClienteInvalidoException;

@Component
public class ValidaEmailClienteRule {

	public void valida(String email){
		if(Objects.isNull(email)){
			throw new EmailClienteInvalidoException("O email do cliente não foi informado.");
		}
		if(email.matches("^.{1,212}@[a-zA-Z]{1,30}\\.[a-zA-Z]{1,3}$") == Boolean.FALSE){
			throw new EmailClienteInvalidoException(" O Email deve ter o formato xxxx@xxx.xx");
		}
	}
}
