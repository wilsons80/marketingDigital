package br.mp.mpdft.mdigital.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.builder.ClienteTOBuilder;
import br.mp.mpdft.mdigital.dao.ClienteDAO;
import br.mp.mpdft.mdigital.entity.Cliente;
import br.mp.mpdft.mdigital.excpetion.EmailClienteNaoInformadoException;
import br.mp.mpdft.mdigital.excpetion.NomeClienteNaoInformadoException;
import br.mp.mpdft.mdigital.excpetion.RendaBrutaMensalNaoInformadaException;
import br.mp.mpdft.mdigital.to.ClienteTO;

@Component
public class CadastrarClienteCmd {

	
	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private ClienteTOBuilder clienteTOBuilder;
	
	public ClienteTO cadastrar(ClienteTO clienteTO){
		if(Objects.isNull(clienteTO.getRendaBrutaMensal())){
			new RendaBrutaMensalNaoInformadaException("A renda bruta mensal não foi informada.");
		}
		
		if(Objects.isNull(clienteTO.getNome())){
			new NomeClienteNaoInformadoException("O nome do cliente não foi informado.");
		}
		
		if(Objects.isNull(clienteTO.getEmail())){
			new EmailClienteNaoInformadoException("O email do cliente não foi informado.");
		}
		
		Cliente cliente = new Cliente(null,
				                      clienteTO.getNome(), 
				                      clienteTO.getNumeroDDD(), 
				                      clienteTO.getTelefone(), 
				                      clienteTO.getEmail(), 
				                      clienteTO.getRendaBrutaMensal());
		
		clienteDAO.insert(cliente);
		return clienteTOBuilder.build(cliente);
	}
}
