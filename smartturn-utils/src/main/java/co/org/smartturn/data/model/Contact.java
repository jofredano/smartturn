package co.org.smartturn.data.model;

import java.io.Serializable;
import java.util.List;

import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.structure.Record;

/**
 * Estructura general de un contacto.
 * Se define asi, porque depende del contexto en el que se hable de usuario
 * Objeto de persistencia o objeto de negocio, se puede definir de la misma manera
 * pero cambia de acuerdo a como vaya orientado.
 * 
 * @author joseanor
 *
 */
public interface Contact<R extends java.io.Serializable> extends Record, MapEntity {

	/**
	 * Devuelve el codigo del contacto
	 * @return	long
	 */
	public long getCode();
	
	/**
	 * Asigna el codigo del contacto
	 * @param 	code	Codigo
	 */
	public void setCode(long code);

	/**
	 * Devuelve el tipo de contacto
	 * @return	Serializable
	 */
	public Serializable getType();
	
	/**
	 * Asigna el tipo de contacto
	 * @param 	type	Tipo de contacto
	 */
	public void setType(Serializable type);
	
	/**
	 * Devuelve el documento de identidad del contacto
	 * @return	Serializable
	 */
	public Serializable getIdentification();
	
	/**
	 * Asigna el documento de identidad al contacto
	 * @param 	identification		Documento de identidad
	 */
	public void setIdentification(Serializable identification);

	/**
	 * Devuelve el primer nombre del contacto
	 * @return	String
	 */
	public String getFirstname();
	
	/**
	 * Asigna el primer nombre del contacto
	 * @param 	firstname	Primer nombre
	 */
	public void setFirstname(String firstname);

	/**
	 * Devuelve el segundo nombre del contacto
	 * @return	String
	 */
	public String getSecondname();
	
	/**
	 * Asigna el segundo nombre del contacto
	 * @param 	secondname	Segundo nombre
	 */
	public void setSecondname(String secondname);
	
	/**
	 * Devuelve el primer apellido del contacto
	 * @return	firstLastname	Primer apellido
	 */
	public String getFirstLastname();
	
	/**
	 * Asigna el primer apellido del contacto
	 * @param 	firstLastname	Primer apellido
	 */
	public void setFirstLastname(String firstLastname);
	
	/**
	 * Devuelve el segundo apellido del contacto
	 * @return	secondLastname	Segundo apellido
	 */
	public String getSecondLastname();
	
	/**
	 * Asigna el segundo apellido del contacto
	 * @param 	secondLastname	Segundo apellido
	 */
	public void setSecondLastname(String secondLastname);

	/**
	 * Devuelve la fecha de nacimiento del contacto
	 * @return	birth
	 */
	public Serializable getBirth();
	
	/**
	 * Asigna la fecha de nacimiento del contacto
	 * @param 	birth	Fecha de nacimiento
	 */
	public void setBirth(Serializable birth);
	
	/**
	 * Devuelve las referencias del contacto.
	 * @return	references
	 */
	public List<R> getReferences();
	
	/**
	 * Asigna las referencias al contacto.
	 * @param 	references		Listado de referencias.
	 */
	public void setReferences(List<R> references);
}

