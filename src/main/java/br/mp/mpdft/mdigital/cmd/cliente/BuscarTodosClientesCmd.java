package br.mp.mpdft.mdigital.cmd.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.builder.ClienteTOBuilder;
import br.mp.mpdft.mdigital.dao.ClienteDAO;
import br.mp.mpdft.mdigital.to.ClienteTO;

@Component
public class BuscarTodosClientesCmd {

	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private ClienteTOBuilder clienteTOBuilder;
	
	public List<ClienteTO> getAll(){
		return clienteTOBuilder.build(clienteDAO.listAll());
	}

}
