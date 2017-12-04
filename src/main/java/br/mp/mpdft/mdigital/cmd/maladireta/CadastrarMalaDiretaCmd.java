package br.mp.mpdft.mdigital.cmd.maladireta;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.builder.MalaDiretaTOBuilder;
import br.mp.mpdft.mdigital.dao.MalaDiretaDAO;
import br.mp.mpdft.mdigital.entity.MalaDireta;
import br.mp.mpdft.mdigital.excpetion.MalaDiretaJaExisteException;
import br.mp.mpdft.mdigital.rule.ValidaFaixaRendaFinalMalaDiretaRule;
import br.mp.mpdft.mdigital.rule.ValidaFaixaRendaInicialMalaDiretaRule;
import br.mp.mpdft.mdigital.rule.ValidaFaixaRendaMalaDiretaRule;
import br.mp.mpdft.mdigital.rule.ValidaNomeMalaDiretaRule;
import br.mp.mpdft.mdigital.to.MalaDiretaTO;

@Component
public class CadastrarMalaDiretaCmd {

	@Autowired
	private MalaDiretaDAO malaDiretaDAO;
	
	@Autowired
	private MalaDiretaTOBuilder malaDiretaTOBuilder;
	
	@Autowired
	private ValidaNomeMalaDiretaRule validaNomeMalaDiretaRule;
	
	@Autowired
	private ValidaFaixaRendaInicialMalaDiretaRule validaFaixaRendaInicialMalaDiretaRule;
	
	@Autowired
	private ValidaFaixaRendaFinalMalaDiretaRule validaFaixaRendaFinalMalaDiretaRule;
	
	@Autowired
	private ValidaFaixaRendaMalaDiretaRule validaFaixaRendaMalaDiretaRule;
	
	public MalaDiretaTO cadastrar(MalaDiretaTO malaDiretaTO){
		
		validaFaixaRendaInicialMalaDiretaRule.valida(malaDiretaTO.getFaixaRendaInicial());
		validaFaixaRendaFinalMalaDiretaRule.valida(malaDiretaTO.getFaixaRendaFinal());
		validaNomeMalaDiretaRule.valida(malaDiretaTO.getNome());
		validaFaixaRendaMalaDiretaRule.valida(malaDiretaTO.getFaixaRendaInicial(), malaDiretaTO.getFaixaRendaFinal());
		
		
		MalaDiretaTO malaPorFaixa = malaDiretaDAO.getMalaDiretaPorFaixa(malaDiretaTO.getFaixaRendaInicial(), malaDiretaTO.getFaixaRendaFinal());
		if(Objects.nonNull(malaPorFaixa)){
			throw new MalaDiretaJaExisteException("Já existe a mala direta com o ID: "+malaPorFaixa.getCodigo()+" com a faixa de renda informada.");
		}
		
		MalaDireta malaDireta = new MalaDireta(null,
				                               malaDiretaTO.getNome(), 
				                               malaDiretaTO.getFaixaRendaInicial(), 
				                               malaDiretaTO.getFaixaRendaFinal());
		malaDiretaDAO.insert(malaDireta);
		return malaDiretaTOBuilder.build(malaDireta);
	}
}
