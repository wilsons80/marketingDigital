package br.mp.mpdft.mdigital.cmd.cliente;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.builder.ClienteTOBuilder;
import br.mp.mpdft.mdigital.dao.ClienteDAO;
import br.mp.mpdft.mdigital.entity.Cliente;
import br.mp.mpdft.mdigital.excpetion.ClienteJaCadastradoException;
import br.mp.mpdft.mdigital.rule.ValidaEmailClienteRule;
import br.mp.mpdft.mdigital.rule.ValidaNomeClienteRule;
import br.mp.mpdft.mdigital.rule.ValidaRendaBrutaClienteRule;
import br.mp.mpdft.mdigital.rule.ValidaTelefoneClienteRule;
import br.mp.mpdft.mdigital.to.ClienteTO;

@Component
public class CadastrarClienteCmd {

	
	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private ClienteTOBuilder clienteTOBuilder;
	
	@Autowired
	private ValidaTelefoneClienteRule validaTelefoneClienteRule;
	
	@Autowired
	private ValidaEmailClienteRule validaEmailClienteRule;
	
	@Autowired
	private ValidaRendaBrutaClienteRule validaRendaBrutaClienteRule;
	
	@Autowired
	private ValidaNomeClienteRule validaNomeClienteRule;
	
	
	public ClienteTO cadastrar(ClienteTO clienteTO){
		validaRendaBrutaClienteRule.valida(clienteTO.getRendaBrutaMensal());
		validaNomeClienteRule.valida(clienteTO.getNome());
		validaEmailClienteRule.valida(clienteTO.getEmail());
		validaTelefoneClienteRule.valida(clienteTO.getTelefone());
		
		
		ClienteTO email = clienteDAO.buscarClientePorEmail(clienteTO.getEmail());
		
		if(Objects.nonNull(email)){
			throw new ClienteJaCadastradoException("Cliente já está cadastrado na base com o email: " + email);
		}
		
		Cliente cliente = new Cliente(null,
				                      clienteTO.getNome(), 
				                      clienteTO.getTelefone(), 
				                      clienteTO.getEmail(), 
				                      clienteTO.getRendaBrutaMensal());
		
		clienteDAO.insert(cliente);
		return clienteTOBuilder.build(cliente);
	}
}
