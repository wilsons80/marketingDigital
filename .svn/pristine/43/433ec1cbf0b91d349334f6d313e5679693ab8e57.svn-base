package br.mp.mpdft.mdigital.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.mp.mpdft.mdigital.cmd.cliente.AlterarClienteCmd;
import br.mp.mpdft.mdigital.cmd.cliente.BuscarClientesPorRendaBrutaCmd;
import br.mp.mpdft.mdigital.cmd.cliente.BuscarTodosClientesCmd;
import br.mp.mpdft.mdigital.cmd.cliente.CadastrarClienteCmd;
import br.mp.mpdft.mdigital.cmd.cliente.ExcluirClienteByIdCmd;
import br.mp.mpdft.mdigital.to.ClienteTO;

@Component
@Path("/cliente")
public class ClienteService {

	@Autowired
	private BuscarClientesPorRendaBrutaCmd buscarClientesPorRendaBrutaCmd; 
	
	@Autowired
	private CadastrarClienteCmd cadastrarClienteCmd;
	
	@Autowired
	private BuscarTodosClientesCmd buscarTodosClientesCmd;
	
	@Autowired
	private ExcluirClienteByIdCmd excluirClienteByIdCmd;
	
	@Autowired
	private AlterarClienteCmd alterarClienteCmd;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public List<ClienteTO> getClientes(){
		return buscarTodosClientesCmd.getAll();
	}
	
	
	@GET
	@Path("/faixaRenda/{faixaRendaInicial}/{faixaRendaFinal}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public List<ClienteTO> getClientesPorMalaDireta(@PathParam("faixaRendaInicial") Double faixaRendaInicial, 
			                                        @PathParam("faixaRendaFinal") Double faixaRendaFinal ){
		return buscarClientesPorRendaBrutaCmd.getClientesPorMalaDireta(faixaRendaInicial, faixaRendaFinal);
	}
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public ClienteTO cadastrar(ClienteTO clienteTO){
		return cadastrarClienteCmd.cadastrar(clienteTO);
	}

	@PUT
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public ClienteTO alterar(@PathParam("codigo") Integer codigo, ClienteTO clienteTO){
		return alterarClienteCmd.alterar(codigo, clienteTO);
	}
	
	
	@DELETE
	@Path("/{codigo}")
	@Transactional
	public void excluir(@PathParam("codigo") Integer idCliente){
		excluirClienteByIdCmd.excluir(idCliente);
	}
}
