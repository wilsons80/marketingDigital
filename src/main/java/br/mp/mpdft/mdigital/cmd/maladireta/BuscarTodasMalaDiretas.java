package br.mp.mpdft.mdigital.cmd.maladireta;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.builder.MalaDiretaTOBuilder;
import br.mp.mpdft.mdigital.dao.MalaDiretaDAO;
import br.mp.mpdft.mdigital.to.MalaDiretaTO;

@Component
public class BuscarTodasMalaDiretas {

	@Autowired
	private MalaDiretaDAO malaDiretaDAO;
	@Autowired
	private MalaDiretaTOBuilder malaDiretaTOBuilder;
	
	public List<MalaDiretaTO> getAll(){
		List<MalaDiretaTO> malas = new ArrayList<MalaDiretaTO>();
		malaDiretaDAO.listAll()
		             .stream()
		             .forEach(m -> malas.add( malaDiretaTOBuilder.build(m) ));
		return malas;
	}
}
