package br.mp.mpdft.mdigital.builder;

import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.entity.Usuario;
import br.mp.mpdft.mdigital.to.UsuarioTO;

@Component
public class UsuarioTOBuilder {

	public UsuarioTO build(Usuario usuario){
		return new UsuarioTO(usuario.getIdUsuario(), usuario.getUsername(), usuario.getSenha(), usuario.getAtivo(), usuario.getTentativasLogin());
	}
}
