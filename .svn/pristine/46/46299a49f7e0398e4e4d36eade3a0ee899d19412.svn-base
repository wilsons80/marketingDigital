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
		MalaDireta malaDireta = new MalaDireta(idMalaDireta, 
				                               malaDiretaTO.getNome(), 
				                               malaDiretaTO.getFaixaRendaInicial(), 
				                               malaDiretaTO.getFaixaRendaFinal());
		malaDiretaDAO.update(malaDireta);
		return buscarMalaDiretaByIdCmd.getMalaDiretaTOByID(idMalaDireta);
	}
}
