package br.mp.mpdft.mdigital.cmd.cliente;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.builder.ClienteTOBuilder;
import br.mp.mpdft.mdigital.dao.ClienteDAO;
import br.mp.mpdft.mdigital.entity.Cliente;
import br.mp.mpdft.mdigital.excpetion.ClienteNaoEncontradoException;
import br.mp.mpdft.mdigital.excpetion.CodigoClienteNaoInformadoException;
import br.mp.mpdft.mdigital.to.ClienteTO;

@Component
public class BuscarClienteByIDCmd {

	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private ClienteTOBuilder clienteTOBuilder;
	
	public Cliente getClienteByCodigo(Integer codigo){
		Cliente cliente = clienteDAO.getPorCodigo(codigo);
		if(Objects.isNull(cliente)){
			throw new ClienteNaoEncontradoException("Cliente n�o encontrado na base de dados");
		}
		return cliente;
	}
	
	public ClienteTO getClienteToByID(Integer id){
		if(Objects.isNull(id)){
			throw new CodigoClienteNaoInformadoException("O c�digo do cliente n�o foi informado.");
		}
		return clienteTOBuilder.build(getClienteByCodigo(id));
	}

}
