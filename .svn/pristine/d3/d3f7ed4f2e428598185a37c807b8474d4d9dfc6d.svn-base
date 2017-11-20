package br.mp.mpdft.mdigital.cmd.usuario;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mp.mpdft.mdigital.builder.UsuarioTOBuilder;
import br.mp.mpdft.mdigital.dao.UsuarioDAO;
import br.mp.mpdft.mdigital.excpetion.CodigoNaoInformadoException;
import br.mp.mpdft.mdigital.to.UsuarioTO;

@Component
public class BuscarUsuarioByIDCmd {

	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private UsuarioTOBuilder usuarioTOBuilder;
	
	public UsuarioTO getByID(Long id){
		if(Objects.isNull(id)){
			throw new CodigoNaoInformadoException("O código do usuário não foi informado.");
		}
		return usuarioTOBuilder.build(usuarioDAO.getPorCodigo(new Integer(id.intValue())));
	}

}
