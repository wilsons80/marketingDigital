package br.mp.mpdft.mdigital.infra.hibernate;

import java.io.Serializable;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.PrimitiveType;
import org.hibernate.type.StringType;
import org.hibernate.type.descriptor.java.BooleanTypeDescriptor;
import org.hibernate.type.descriptor.sql.CharTypeDescriptor;

/**
 * Classe para poder mapear um char no banco para um atributo Boolean na aplicação
 * 
 */
public class SimNaoType extends AbstractSingleColumnStandardBasicType<Boolean> implements PrimitiveType<Boolean>, DiscriminatorType<Boolean> {
	private static final long serialVersionUID = -2349928119026464287L;
	/**
	 * Obtém o caracter que representa o true
	 * 
	 * @return String contendo o dado
	 */


	/**
	 * Construtor similar ao {@link org.hibernate.type.YesNoType}
	 * 
	 * @return String contendo o dado
	 */

	public SimNaoType() {
		super(CharTypeDescriptor.INSTANCE, new BooleanTypeDescriptor('S','N'));
	}

	/**
	 * Obtém a representação do nome da classe
	 * 
	 * @return String contendo o dado
	 */

	public String getName() {
		return HibernateTypes.SimNaoType;
	}

	@Override
	public String objectToSQLString(Boolean value, Dialect dialect) throws Exception {
		return StringType.INSTANCE.objectToSQLString(value.booleanValue() ? "S" : "N", dialect);
	}
	
	

	@SuppressWarnings("rawtypes")
	@Override
	public Class getPrimitiveClass() {
		return boolean.class;
	}

	@Override
	public Serializable getDefaultValue() {
		return Boolean.FALSE;
	}

	@Override
	public Boolean stringToObject(String xml) throws Exception {
		return fromString(xml);
	}

}