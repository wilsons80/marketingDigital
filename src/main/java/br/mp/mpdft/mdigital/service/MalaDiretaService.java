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

import br.mp.mpdft.mdigital.cmd.maladireta.AlterarMalaDiretaCmd;
import br.mp.mpdft.mdigital.cmd.maladireta.BuscarTodasMalaDiretas;
import br.mp.mpdft.mdigital.cmd.maladireta.CadastrarMalaDiretaCmd;
import br.mp.mpdft.mdigital.cmd.maladireta.ExcluirMalaDiretaByIdCmd;
import br.mp.mpdft.mdigital.to.MalaDiretaTO;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/maladireta")
@Component
public class MalaDiretaService {

	@Autowired
	private CadastrarMalaDiretaCmd cadastrarMalaDiretaCmd;
	@Autowired
	private BuscarTodasMalaDiretas buscarTodasMalaDiretas;
	@Autowired
	private ExcluirMalaDiretaByIdCmd excluirMalaDiretaByIdCmd;
	@Autowired
	private AlterarMalaDiretaCmd alterarMalaDiretaCmd;
	
	@Path("/")
	@GET
	@Transactional
	public List<MalaDiretaTO> getAll(){
		return buscarTodasMalaDiretas.getAll();
	}

	@Path("/")
	@POST
	@Transactional
	public MalaDiretaTO cadastrar(MalaDiretaTO malaDiretaTO){
		return cadastrarMalaDiretaCmd.cadastrar(malaDiretaTO);
	}
	
	@Path("/{idMalaDireta}")
	@DELETE
	@Transactional
	public MalaDiretaTO excluir(@PathParam("idMalaDireta") Integer idMalaDireta){
		return excluirMalaDiretaByIdCmd.excluir(idMalaDireta);
	}
	
	
	@Path("/{idMalaDireta}")
	@PUT
	@Transactional
	public MalaDiretaTO alterar(@PathParam("idMalaDireta") Integer idMalaDireta, 
			                    MalaDiretaTO malaDiretaTO){
		return alterarMalaDiretaCmd.alterar(idMalaDireta, malaDiretaTO);
	}
	
}
