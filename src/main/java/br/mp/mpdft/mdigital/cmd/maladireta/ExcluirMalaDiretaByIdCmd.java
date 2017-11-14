package br.mp.mpdft.mdigital.cmd.maladireta;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.builder.MalaDiretaTOBuilder;
import br.mp.mpdft.mdigital.dao.MalaDiretaDAO;
import br.mp.mpdft.mdigital.entity.MalaDireta;
import br.mp.mpdft.mdigital.excpetion.MalaDiretaNaoEncontradaException;
import br.mp.mpdft.mdigital.to.MalaDiretaTO;

@Component
public class ExcluirMalaDiretaByIdCmd {

	@Autowired
	private MalaDiretaDAO malaDiretaDAO;
	@Autowired
	private BuscarMalaDiretaByIDCmd buscarMalaDiretaByIDCmd;
	@Autowired
	private MalaDiretaTOBuilder malaDiretaTOBuilder;
	
	
	public MalaDiretaTO excluir(Integer idMalaDireta){
		MalaDireta malaDireta = buscarMalaDiretaByIDCmd.getByID(idMalaDireta);
		if(Objects.isNull(malaDireta)){
			throw new MalaDiretaNaoEncontradaException("A Mala Direta de código " + idMalaDireta + " não foi encontrada na base de dados.");
		}
		
		malaDiretaDAO.delete(malaDireta);
		return malaDiretaTOBuilder.build(malaDireta);
	}
}
