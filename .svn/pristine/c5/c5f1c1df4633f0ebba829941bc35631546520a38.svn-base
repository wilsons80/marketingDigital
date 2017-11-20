package br.mp.mpdft.mdigital.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.entity.Cliente;
import br.mp.mpdft.mdigital.to.ClienteTO;

@Component
public class ClienteTOBuilder {

	public ClienteTO build(Cliente cliente){
		return new ClienteTO(cliente.getIdCliente       (), 
				             cliente.getNome            (), 
				             cliente.getTelefone        (), 
				             cliente.getEmail           (), 
				             cliente.getRendaBrutaMensal());
	}
	
	public List<ClienteTO> build(List<Cliente> clientes){
		List<ClienteTO> clientesTO = new ArrayList<ClienteTO>();
		clientes.stream()
		        .forEach(c -> clientesTO.add(build(c)) );
		
		return clientesTO;
	}
}
