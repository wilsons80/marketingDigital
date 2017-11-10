package br.mp.mpdft.mdigital.service;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.mp.mpdft.mdigital.cmd.BloquearUsuarioCmd;
import br.mp.mpdft.mdigital.cmd.BuscarUsuarioByUserNameCmd;
import br.mp.mpdft.mdigital.to.UsuarioTO;

@Component
@Path("/usuario")
public class UsuarioService {

	@Autowired
	private BuscarUsuarioByUserNameCmd buscarUsuarioByUserNameCmd;  
	@Autowired
	private BloquearUsuarioCmd bloquearUsuarioCmd;
	
	
	@GET
	@Path("/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public UsuarioTO getByUserName(@PathParam("userName") String userName){
		return buscarUsuarioByUserNameCmd.getByUserName(userName);
	}
	
	@PUT
	@Path("/{codigo}")
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioTO bloquerUsuario(@PathParam("codigo") Integer codigo){
		return bloquearUsuarioCmd.bloquerUsuario(codigo);
	}
}
