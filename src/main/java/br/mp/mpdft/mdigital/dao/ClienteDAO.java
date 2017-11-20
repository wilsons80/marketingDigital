package br.mp.mpdft.mdigital.dao;

import static br.mp.mpdft.mdigital.entity.QCliente.cliente;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mysema.query.jpa.hibernate.HibernateQuery;
import com.mysema.query.types.ConstructorExpression;

import br.mp.mpdft.mdigital.entity.Cliente;
import br.mp.mpdft.mdigital.infra.dao.BaseDAO;
import br.mp.mpdft.mdigital.to.ClienteTO;

@Repository
public class ClienteDAO extends BaseDAO<Cliente>{

	public ClienteDAO() {
	}
	
	public ClienteTO buscarClientePorEmail(String email){
		HibernateQuery query = new HibernateQuery(getSession());
		return query.from(cliente)
	            .where(cliente.email.eq(email))
	            .singleResult(ConstructorExpression.create(ClienteTO.class, cliente.idCliente, 
	            		                                                    cliente.nome,
	            		                                                    cliente.telefone,
	            		                                                    cliente.email,
	            		                                                    cliente.rendaBrutaMensal
	            		                                                    ));
	}
	
	public List<ClienteTO> getClientesPorMalaDireta(Double faixaRendaInicial, Double faixaRendaFinal ){
		HibernateQuery query = new HibernateQuery(getSession());

		// @formatter:off
		return query.from(cliente)
		            .where(cliente.rendaBrutaMensal.between(faixaRendaInicial, faixaRendaFinal))
		            .list(ConstructorExpression.create(ClienteTO.class, cliente.idCliente, 
		            		                                                    cliente.nome,
		            		                                                    cliente.telefone,
		            		                                                    cliente.email,
		            		                                                    cliente.rendaBrutaMensal
		            		                                                    ));
		// @formatter:off

	}
}
