package br.mp.mpdft.mdigital.builder;

import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.entity.MalaDireta;
import br.mp.mpdft.mdigital.to.MalaDiretaTO;

@Component
public class MalaDiretaTOBuilder {
	
	public MalaDiretaTO build(MalaDireta malaDireta){
		return new MalaDiretaTO(malaDireta.getIdMalaDireta(), 
				                malaDireta.getNome(), 
				                malaDireta.getFaixaRendaInicial(), 
				                malaDireta.getFaixaRendaFinal());
	}
}
