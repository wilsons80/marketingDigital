package br.mp.mpdft.mdigital.cmd.cliente;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.dao.ClienteDAO;
import br.mp.mpdft.mdigital.entity.Cliente;
import br.mp.mpdft.mdigital.excpetion.RendaBrutaMensalInvalidaException;
import br.mp.mpdft.mdigital.to.ClienteTO;

@Component
public class AlterarClienteCmd {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private BuscarClienteByIDCmd buscarClienteByIDCmd;
	
	public ClienteTO alterar(Integer idCliente, ClienteTO clienteTO){
		
		if(Objects.isNull(clienteTO.getRendaBrutaMensal())){
			new RendaBrutaMensalInvalidaException("A renda bruta mensal não foi informada.");
		}
		if(clienteTO.getRendaBrutaMensal().toString().replace(".", ",").matches("^[0-9]{0,6},[0-9]{2}$") == Boolean.FALSE){
			new RendaBrutaMensalInvalidaException("O valor de renda bruta mensal não está formato válido (999999,99) - Valor informado:" + clienteTO.getRendaBrutaMensal());
		}

		
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
