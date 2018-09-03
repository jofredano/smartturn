package co.org.smartturn.data.transfer;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import co.org.smartturn.data.model.Client;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.adapter.DateAdapter;
import co.org.smartturn.data.transfer.fields.ColumnFields;
import co.org.smartturn.data.transfer.structure.ObjectMap;
import co.org.smartturn.exception.transfer.MapperException;

/**
 * Objeto que define a un cliente del sistema. 
 * 
 * @author joseanor
 *
 */
public final class DTOClient extends ObjectMap implements Client, MapEntity {

	private static final long serialVersionUID = 1L;


	/**
	 * Fecha de creacion.
	 */
	@XmlElement(name = "created")
    @XmlJavaTypeAdapter( DateAdapter.class )
	private java.util.Date created;

	/**
	 * Fecha de modificacion.
	 */
	@XmlElement(name = "modified")
    @XmlJavaTypeAdapter( DateAdapter.class )
	private java.util.Date modified;
	
	/**
	 * Estado del contacto.
	 */
	private Serializable state;

	/**
	 * Usuario que creo el cliente.
	 */
	private Serializable creater;

	/**
	 * Usuario que realizo la ultima modificacion.
	 */
	private Serializable modifier;

	/**
	 * Codigo unico del cliente.
	 */
	private long code;

	/**
	 * Informacion del contacto.
	 */
	private Serializable contact;
	

	@Override
	public Serializable getCreated() {
		return created;
	}

	@Override
	public void setCreated(Serializable created) {
		this.created = (Date) created;
	}

	@Override
	public Serializable getModified() {
		return modified;
	}

	@Override
	public void setModified(Serializable modified) {
		this.modified = (Date) modified;
	}

	@Override
	public Serializable getState() {
		return state;
	}

	@Override
	public void setState(Serializable state) {
		this.state = state;
	}

	@Override
	public Serializable getCreater() {
		return creater;
	}

	@Override
	public void setCreater(Serializable creater) {
		this.creater = creater;
	}

	@Override
	public Serializable getModifier() {
		return modifier;
	}

	@Override
	public void setModifier(Serializable modifier) {
		this.modifier = modifier;
	}

	@Override
	public Serializable get(Field field) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case CLIENT_CODE 		:  return getCode( );  
			case CLIENT_CREATED 	:  return getCreated( );  
			case CLIENT_CREATER 	:  return getCreater( );  
			case CLIENT_MODIFIED 	:  return getModified( );  
			case CLIENT_MODIFIER 	:  return getModifier( );  
			case CLIENT_STATE 		:  return getState( ); 
			case CLIENT_REFERENCE	:  return getContact( );
			default					:  return null;	
		}
	}

	@Override
	public void put(Field field, Serializable value) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case CLIENT_CODE 		:  setCode( (long)value ); break; 
			case CLIENT_CREATED 	:  setCreated( value ); break; 
			case CLIENT_CREATER 	:  setCreater( value ); break; 
			case CLIENT_MODIFIED 	:  setModified( value ); break; 
			case CLIENT_MODIFIER 	:  setModifier( value ); break; 
			case CLIENT_STATE 		:  setState( value ); break;
			case CLIENT_REFERENCE	:  setContact( value ); break;
			default					:  break;	
		}
	}

	@Override
	public long getCode() {
		return code;
	}

	@Override
	public void setCode(long code) {
		this.code = code;
	}

	@Override
	public Serializable getContact() {
		return contact;
	}

	@Override
	public void setContact(Serializable contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode( ) {
		return  (Long.valueOf(code)).hashCode();
	}
	
	@Override
	public boolean equals(Object object) {
		if(object == null || object.getClass() != this.getClass()) {
		   return false;
		}
		return (this.hashCode() == ((DTOProfile)object).hashCode());
	}

	@Override
	public MapEntity map(Class<?> name, MapEntity source) throws MapperException {
		return null;
	}
	
}
