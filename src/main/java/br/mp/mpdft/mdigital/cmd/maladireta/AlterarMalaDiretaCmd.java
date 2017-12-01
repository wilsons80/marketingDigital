package br.mp.mpdft.mdigital.cmd.maladireta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.dao.MalaDiretaDAO;
import br.mp.mpdft.mdigital.entity.MalaDireta;
import br.mp.mpdft.mdigital.to.MalaDiretaTO;

@Component
public class AlterarMalaDiretaCmd {

	@Autowired
	private MalaDiretaDAO malaDiretaDAO;
	@Autowired
	private BuscarMalaDiretaByIDCmd buscarMalaDiretaByIdCmd;
	
	public MalaDiretaTO alterar(Integer idMalaDireta, MalaDiretaTO malaDiretaTO){
		
		//Busca o objeto da Base de dados para evitar inconsistencia.
		MalaDireta malaDireta = buscarMalaDiretaByIdCmd.getByID(idMalaDireta);
		
		malaDireta.setNome             (malaDiretaTO.getNome());
		malaDireta.setFaixaRendaInicial(malaDiretaTO.getFaixaRendaInicial());
		malaDireta.setFaixaRendaFinal  (malaDiretaTO.getFaixaRendaFinal());
		malaDiretaDAO.update(malaDireta);
		
		return buscarMalaDiretaByIdCmd.getMalaDiretaTOByID(idMalaDireta);
	}
}
