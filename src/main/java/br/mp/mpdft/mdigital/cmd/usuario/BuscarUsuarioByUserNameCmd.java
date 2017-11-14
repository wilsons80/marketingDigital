package br.mp.mpdft.mdigital.cmd.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.dao.UsuarioDAO;
import br.mp.mpdft.mdigital.to.UsuarioTO;

@Component
public class BuscarUsuarioByUserNameCmd {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public UsuarioTO getByUserName(String userName){
		return usuarioDAO.getByUserName(userName);
	}

}
