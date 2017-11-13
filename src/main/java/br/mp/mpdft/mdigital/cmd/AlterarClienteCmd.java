package br.mp.mpdft.mdigital.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.dao.ClienteDAO;
import br.mp.mpdft.mdigital.entity.Cliente;
import br.mp.mpdft.mdigital.to.ClienteTO;

@Component
public class AlterarClienteCmd {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private BuscarClienteByIDCmd buscarClienteByIDCmd;
	
	public ClienteTO alterar(Integer idCliente, ClienteTO clienteTO){
		Cliente cliente = new Cliente(idCliente,
				                      clienteTO.getNome(), 
				                      clienteTO.getNumeroDDD(), 
				                      clienteTO.getTelefone(), 
				                      clienteTO.getEmail(), 
				                      clienteTO.getRendaBrutaMensal()); 
		clienteDAO.update(cliente);
		return buscarClienteByIDCmd.getClienteToByID(idCliente);
	}
}
