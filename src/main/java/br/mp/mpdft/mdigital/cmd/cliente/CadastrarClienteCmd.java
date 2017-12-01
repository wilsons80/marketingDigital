package br.mp.mpdft.mdigital.cmd.cliente;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.builder.ClienteTOBuilder;
import br.mp.mpdft.mdigital.dao.ClienteDAO;
import br.mp.mpdft.mdigital.entity.Cliente;
import br.mp.mpdft.mdigital.excpetion.ClienteJaCadastradoException;
import br.mp.mpdft.mdigital.excpetion.EmailClienteNaoInformadoException;
import br.mp.mpdft.mdigital.excpetion.NomeNaoInformadoException;
import br.mp.mpdft.mdigital.excpetion.RendaBrutaMensalInvalidaException;
import br.mp.mpdft.mdigital.to.ClienteTO;

@Component
public class CadastrarClienteCmd {

	
	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private ClienteTOBuilder clienteTOBuilder;
	
	public ClienteTO cadastrar(ClienteTO clienteTO){
		if(Objects.isNull(clienteTO.getRendaBrutaMensal())){
			new RendaBrutaMensalInvalidaException("A renda bruta mensal não foi informada.");
		}
		if(clienteTO.getRendaBrutaMensal().toString().replace(".", ",").matches("^[0-9]{0,6},[0-9]{2}$") == Boolean.FALSE){
			new RendaBrutaMensalInvalidaException("O valor de renda bruta mensal não está formato válido (999999,99) - Valor informado:" + clienteTO.getRendaBrutaMensal());
		}
		
		if(Objects.isNull(clienteTO.getNome())){
			new NomeNaoInformadoException("O nome do cliente não foi informado.");
		}
		
		if(Objects.isNull(clienteTO.getEmail())){
			new EmailClienteNaoInformadoException("O email do cliente não foi informado.");
		}
		
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
