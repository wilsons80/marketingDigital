package br.mp.mpdft.mdigital.dao;

import static br.mp.mpdft.mdigital.entity.QUsuario.usuario;

import org.springframework.stereotype.Repository;

import com.mysema.query.jpa.hibernate.HibernateQuery;
import com.mysema.query.types.ConstructorExpression;

import br.mp.mpdft.mdigital.entity.Usuario;
import br.mp.mpdft.mdigital.infra.dao.BaseDAO;
import br.mp.mpdft.mdigital.to.UsuarioTO;

@Repository
public class UsuarioDAO extends BaseDAO<Usuario>{

	public UsuarioDAO() {}
	
	public UsuarioTO getByUserName(String userName){
		HibernateQuery query = new HibernateQuery(getSession());

		// @formatter:off
		return query.from(usuario)
		            .where(usuario.username.eq(userName))
		            .singleResult(ConstructorExpression.create(UsuarioTO.class, usuario.idUsuario, 
		            		                                                    usuario.username, 
		            		                                                    usuario.senha,
		            		                                                    usuario.ativo, 
		            		                                                    usuario.tentativasLogin));
	}
	
}
