package co.org.smartturn.data.model;

import java.io.Serializable;

import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.structure.Record;

/**
 * Estructura general de una referencia.
 * Se define asi, porque depende del contexto en el que se hable
 * Objeto de persistencia o objeto de negocio, se puede definir de la misma manera
 * pero cambia de acuerdo a como vaya orientado.
 * 
 * @author joseanor
 *
 */
public interface Reference extends Record, MapEntity {

	/**
	 * Devuelve el codigo de referencia
	 * @return	long
	 */
	public long getCode();
	
	/**
	 * Asigna el codigo de referencia
	 * @param 	code	Codigo
	 */
	public void setCode(long code);

	/**
	 * Devuelve el tipo de referencia
	 * @return	Serializable
	 */
	public Serializable getType();
	
	/**
	 * Asigna el tipo de referencia
	 * @param 	type	Tipo de referencia
	 */
	public void setType(Serializable type);


	/**
	 * Devuelve el tipo de referencia
	 * @return	Serializable
	 */
	public Serializable getCategory();
	
	/**
	 * Asigna el tipo de referencia
	 * @param 	category	Categoria de referencia
	 */
	public void setCategory(Serializable category);

	/**
	 * Devuelve si tiene preferencia
	 * @return	preference
	 */
	public boolean isPreference();

	/**
	 * Asigna la preferencia a esta referencia
	 * @param 	preference	TRUE si esta referencia es preferida
	 */
	public void setPreference(boolean preference);
	
	/**
	 * Devuelve el valor de la referencia
	 * @return	value	
	 */
	public String getValue();
	
	/**
	 * Asigna el valor a la referencia.
	 * @param 	value
	 */
	public void setValue(String value);

	/**
	 * Retorna la informacion de contacto
	 * @return	contact
	 */
	public Long getContact();

	/**
	 * Asigna la informacion del contacto
	 * @param contact
	 */
	public void setContact(Long contact);

}

