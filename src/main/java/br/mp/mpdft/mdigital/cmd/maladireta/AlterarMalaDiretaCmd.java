package br.mp.mpdft.mdigital.cmd.maladireta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.dao.MalaDiretaDAO;
import br.mp.mpdft.mdigital.entity.MalaDireta;
import br.mp.mpdft.mdigital.rule.ValidaFaixaRendaFinalMalaDiretaRule;
import br.mp.mpdft.mdigital.rule.ValidaFaixaRendaInicialMalaDiretaRule;
import br.mp.mpdft.mdigital.rule.ValidaFaixaRendaMalaDiretaRule;
import br.mp.mpdft.mdigital.rule.ValidaNomeMalaDiretaRule;
import br.mp.mpdft.mdigital.to.MalaDiretaTO;

@Component
public class AlterarMalaDiretaCmd {

	@Autowired
	private MalaDiretaDAO malaDiretaDAO;
	@Autowired
	private BuscarMalaDiretaByIDCmd buscarMalaDiretaByIdCmd;

	@Autowired
	private ValidaNomeMalaDiretaRule validaNomeMalaDiretaRule;
	
	@Autowired
	private ValidaFaixaRendaInicialMalaDiretaRule validaFaixaRendaInicialMalaDiretaRule;
	
	@Autowired
	private ValidaFaixaRendaFinalMalaDiretaRule validaFaixaRendaFinalMalaDiretaRule;
	
	@Autowired
	private ValidaFaixaRendaMalaDiretaRule validaFaixaRendaMalaDiretaRule;

	
	public MalaDiretaTO alterar(Integer idMalaDireta, MalaDiretaTO malaDiretaTO){
		
		validaFaixaRendaInicialMalaDiretaRule.valida(malaDiretaTO.getFaixaRendaInicial());
		validaFaixaRendaFinalMalaDiretaRule.valida(malaDiretaTO.getFaixaRendaFinal());
		validaNomeMalaDiretaRule.valida(malaDiretaTO.getNome());
		validaFaixaRendaMalaDiretaRule.valida(malaDiretaTO.getFaixaRendaInicial(), malaDiretaTO.getFaixaRendaFinal());

		
		//Busca o objeto da Base de dados para evitar inconsistencia.
		MalaDireta malaDireta = buscarMalaDiretaByIdCmd.getByID(idMalaDireta);
		
		malaDireta.setNome             (malaDiretaTO.getNome());
		malaDireta.setFaixaRendaInicial(malaDiretaTO.getFaixaRendaInicial());
		malaDireta.setFaixaRendaFinal  (malaDiretaTO.getFaixaRendaFinal());
		malaDiretaDAO.update(malaDireta);
		
		return buscarMalaDiretaByIdCmd.getMalaDiretaTOByID(idMalaDireta);
	}
}
