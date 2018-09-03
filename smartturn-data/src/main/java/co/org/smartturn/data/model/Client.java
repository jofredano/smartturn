package co.org.smartturn.data.model;

import java.io.Serializable;

import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.Record;
import co.org.smartturn.data.transfer.fields.ColumnFields;

/**
 * Estructura general de un cliente.
 * Se define asi, porque depende del contexto en el que se hable
 * Objeto de persistencia o objeto de negocio, se puede definir de la misma manera
 * pero cambia de acuerdo a como vaya orientado.
 * 
 * @author joseanor
 *
 */
public interface Client extends Record {

	/**
	 * Devuelve el codigo del cliente
	 * @return	long
	 */
	public long getCode();
	
	/**
	 * Asigna el codigo del cliente
	 * @param 	code	Codigo
	 */
	public void setCode(long code);
	
	/**
	 * Obtiene la informacion base del usuario
	 * (puede ser toda la informacion de contacto) 
	 * 
	 * @return	contact
	 */
	public Serializable getContact();
	
	/**
	 * Asigna la informacion de contacto del usuario
	 * @param 	contact		Informacion de contacto
	 */
	public void setContact(Serializable contact);
	
	public default Field[] getFields() { 
		return new ColumnFields[] {
			ColumnFields.CLIENT_CODE,
			ColumnFields.CLIENT_CREATED,
			ColumnFields.CLIENT_MODIFIED,
			ColumnFields.CLIENT_CREATER,
			ColumnFields.CLIENT_MODIFIER,
			ColumnFields.CLIENT_STATE,
			ColumnFields.CLIENT_REFERENCE
		}; 
	}
}
