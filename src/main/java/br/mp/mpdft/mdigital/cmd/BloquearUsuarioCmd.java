package br.mp.mpdft.mdigital.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.builder.UsuarioTOBuilder;
import br.mp.mpdft.mdigital.dao.UsuarioDAO;
import br.mp.mpdft.mdigital.entity.Usuario;
import br.mp.mpdft.mdigital.excpetion.UsuarioNaoEncontradoException;
import br.mp.mpdft.mdigital.to.UsuarioTO;

@Component
public class BloquearUsuarioCmd {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private UsuarioTOBuilder usuarioTOBuilder;
	
	public UsuarioTO bloquerUsuario(Integer codigo){
		Usuario usuario = usuarioDAO.getPorCodigo(codigo);
		if(Objects.isNull(usuario)){
			new UsuarioNaoEncontradoException("Usuário não encontrado na base de dados.");
		}
		
		usuario.setAtivo(false);
		usuarioDAO.update(usuario);
		return usuarioTOBuilder.build(usuario);
	}
	
}
