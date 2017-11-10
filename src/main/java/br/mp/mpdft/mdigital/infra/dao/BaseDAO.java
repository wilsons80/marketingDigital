package br.mp.mpdft.mdigital.infra.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base DAO, possui as operações mais comuns para acesso e manipulação dos dados.
 *
 * @param <D>
 */
public class BaseDAO<D> {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Retorna a classe da entidade JPA
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected final Class<D> getEntityClass() {
		ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
		Class<D> clazz = (Class<D>) (superclass).getActualTypeArguments()[0];

		return clazz;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Insere a entidade
	 *
	 * @param entity
	 */
	public void insert(final D entity) {
		getSession().save(entity);
	}

	/**
	 * Insere a lista de entidades
	 *
	 * @param entity
	 */
	public void insert(final List<D> entities) {
		for (D entity : entities) {
			getSession().save(entity);
		}
	}

	/**
	 * Atualiza as informações da entidade
	 *
	 * @param entity
	 */
	public void update(final D entity) {
		getSession().update(entity);
	}

	/**
	 * Exclui fisicamente a entidade
	 *
	 * @param entity
	 */
	public void delete(final D entity) {
		getSession().delete(entity);
	}

	public void flush() {
		getSession().flush();
	}

	protected Criteria criteria() {
           return getSession().createCriteria(getEntityClass());
    }

    /**
     * Lista todas as entidades
     * @return {@link List} de filhas de {@link PersistentEntity}
     */
    @SuppressWarnings("unchecked")
    public List<D> listAll(){
            return criteria().list();
    }


	/**
	 * Retorna a entidade conforme o código (chave primária padrão) passada por parâmetro. Se a chave primária não for o campo codigo do objeto pode retornar resultados
	 * inesperados.
	 *
	 * @param codigo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public D getPorCodigo(final Integer codigo) {
		return (D) getSession().get(getEntityClass(), codigo);
	}

	protected String getEntityName() {
		return getEntityClass().getName();
	}

	@SuppressWarnings("unchecked")
	public D getReference(final Integer codigo) {
		return (D) getSession().load(getEntityClass(), codigo);
	}

	public void evict(final D entity) {
		getSession().evict(entity);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}