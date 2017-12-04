package br.mp.mpdft.mdigital.cmd.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.dao.ClienteDAO;
import br.mp.mpdft.mdigital.entity.Cliente;
import br.mp.mpdft.mdigital.rule.ValidaEmailClienteRule;
import br.mp.mpdft.mdigital.rule.ValidaNomeClienteRule;
import br.mp.mpdft.mdigital.rule.ValidaRendaBrutaClienteRule;
import br.mp.mpdft.mdigital.rule.ValidaTelefoneClienteRule;
import br.mp.mpdft.mdigital.to.ClienteTO;

@Component
public class AlterarClienteCmd {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private BuscarClienteByIDCmd buscarClienteByIDCmd;
	
	@Autowired
	private ValidaTelefoneClienteRule validaTelefoneClienteRule;
	
	@Autowired
	private ValidaEmailClienteRule validaEmailClienteRule;
	
	@Autowired
	private ValidaRendaBrutaClienteRule validaRendaBrutaClienteRule;
	
	@Autowired
	private ValidaNomeClienteRule validaNomeClienteRule;

	
	public ClienteTO alterar(Integer idCliente, ClienteTO clienteTO){

		validaRendaBrutaClienteRule.valida(clienteTO.getRendaBrutaMensal());
		validaNomeClienteRule.valida(clienteTO.getNome());
		validaEmailClienteRule.valida(clienteTO.getEmail());
		validaTelefoneClienteRule.valida(clienteTO.getTelefone());

		
		//Busca o objeto da Base de dados para evitar inconsistencia.
		Cliente cliente = buscarClienteByIDCmd.getClienteByCodigo(idCliente);
		cliente.setNome            (clienteTO.getNome());
		cliente.setTelefone        (clienteTO.getTelefone());
		cliente.setEmail           (clienteTO.getEmail());
		cliente.setRendaBrutaMensal(clienteTO.getRendaBrutaMensal());
		clienteDAO.update(cliente);
		
		return buscarClienteByIDCmd.getClienteToByID(idCliente);
	}
}
