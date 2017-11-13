package br.mp.mpdft.mdigital.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.builder.ClienteTOBuilder;
import br.mp.mpdft.mdigital.dao.ClienteDAO;
import br.mp.mpdft.mdigital.excpetion.CodigoClienteNaoInformadoException;
import br.mp.mpdft.mdigital.to.ClienteTO;

@Component
public class BuscarMalaDiretaByIDCmd {

	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private ClienteTOBuilder clienteTOBuilder;
	
	
	public ClienteTO getByID(Integer id){
		if(Objects.isNull(id)){
			throw new CodigoClienteNaoInformadoException("O código do cliente não foi informado.");
		}
		return clienteTOBuilder.build(clienteDAO.getPorCodigo(id));
	}

}
