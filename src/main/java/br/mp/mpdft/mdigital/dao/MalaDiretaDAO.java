package br.mp.mpdft.mdigital.dao;

import org.springframework.stereotype.Repository;

import com.mysema.query.jpa.hibernate.HibernateQuery;
import com.mysema.query.types.ConstructorExpression;

import br.mp.mpdft.mdigital.entity.MalaDireta;
import static br.mp.mpdft.mdigital.entity.QMalaDireta.malaDireta;
import br.mp.mpdft.mdigital.infra.dao.BaseDAO;
import br.mp.mpdft.mdigital.to.MalaDiretaTO;

@Repository
public class MalaDiretaDAO extends BaseDAO<MalaDireta>{

	public MalaDiretaDAO() {}
	
	public MalaDiretaTO getMalaDiretaPorFaixa(Double faixaInicial, Double faixaFinal){
		HibernateQuery query = new HibernateQuery(getSession());
		
		return query.from(malaDireta)
		            .where(malaDireta.faixaRendaInicial.between(faixaInicial, faixaFinal)
		            .or(malaDireta.faixaRendaFinal.between(faixaInicial, faixaFinal) ))
		            .singleResult(ConstructorExpression.create(MalaDiretaTO.class, malaDireta.idMalaDireta, 
		    		                                                               malaDireta.nome, 
		    		                                                               malaDireta.faixaRendaInicial, 
		    		                                                               malaDireta.faixaRendaFinal));
	}
	
}
