package br.mp.mpdft.mdigital.cmd.maladireta;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.builder.MalaDiretaTOBuilder;
import br.mp.mpdft.mdigital.dao.MalaDiretaDAO;
import br.mp.mpdft.mdigital.entity.MalaDireta;
import br.mp.mpdft.mdigital.excpetion.FaixaRendaNaoInformadaException;
import br.mp.mpdft.mdigital.excpetion.NomeNaoInformadoException;
import br.mp.mpdft.mdigital.to.MalaDiretaTO;

@Component
public class CadastrarMalaDiretaCmd {

	@Autowired
	private MalaDiretaDAO malaDiretaDAO;
	
	@Autowired
	private MalaDiretaTOBuilder malaDiretaTOBuilder;
	
	public MalaDiretaTO cadastrar(MalaDiretaTO malaDiretaTO){
		
		if(Objects.isNull(malaDiretaTO.getFaixaRendaInicial())){
			throw new FaixaRendaNaoInformadaException("A faixa de renda inicial da Mala Direta não foi informada.");
		}
		if(Objects.isNull(malaDiretaTO.getFaixaRendaFinal())){
			throw new FaixaRendaNaoInformadaException("A faixa de renda final da Mala Direta não foi informada.");
		}
		if(Objects.isNull(malaDiretaTO.getNome())){
			throw new NomeNaoInformadoException("O nome da Mala Direta não foi informado.");
		}
		
		MalaDireta malaDireta = new MalaDireta(null,
				                               malaDiretaTO.getNome(), 
				                               malaDiretaTO.getFaixaRendaInicial(), 
				                               malaDiretaTO.getFaixaRendaFinal());
		malaDiretaDAO.insert(malaDireta);
		return malaDiretaTOBuilder.build(malaDireta);
	}
}
