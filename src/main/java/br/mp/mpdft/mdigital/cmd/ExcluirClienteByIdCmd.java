package br.mp.mpdft.mdigital.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.dao.ClienteDAO;
import br.mp.mpdft.mdigital.entity.Cliente;

@Component
public class ExcluirClienteByIdCmd {

	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private BuscarClienteByIDCmd buscarClienteByIDCmd;
	
	public void excluir(Integer idCliente){
		Cliente cliente = buscarClienteByIDCmd.getClienteByCodigo(idCliente);
		clienteDAO.delete(cliente);
	}
	
}
