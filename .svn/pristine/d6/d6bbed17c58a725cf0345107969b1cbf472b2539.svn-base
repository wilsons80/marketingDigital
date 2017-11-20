package br.mp.mpdft.mdigital.cmd.maladireta;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.builder.MalaDiretaTOBuilder;
import br.mp.mpdft.mdigital.dao.MalaDiretaDAO;
import br.mp.mpdft.mdigital.entity.MalaDireta;
import br.mp.mpdft.mdigital.excpetion.CodigoNaoInformadoException;
import br.mp.mpdft.mdigital.to.MalaDiretaTO;

@Component
public class BuscarMalaDiretaByIDCmd {

	@Autowired
	private MalaDiretaDAO malaDiretaDAO;
	@Autowired
	private MalaDiretaTOBuilder malaDiretaTOBuilder;
	

	public MalaDireta getByID(Integer idMalaDireta){
		if(Objects.isNull(idMalaDireta)){
			throw new CodigoNaoInformadoException("O código da Mala Direta não foi informado.");
		}
		return malaDiretaDAO.getPorCodigo(idMalaDireta);
	}

	
	public MalaDiretaTO getMalaDiretaTOByID(Integer idMalaDireta){
		return malaDiretaTOBuilder.build(malaDiretaDAO.getPorCodigo(idMalaDireta));
	}

}
