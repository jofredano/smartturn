package co.org.smartturn.data.transfer;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import co.org.smartturn.data.model.Profile;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.adapter.DateAdapter;
import co.org.smartturn.data.transfer.fields.ColumnFields;
import co.org.smartturn.data.transfer.structure.ObjectMap;
import co.org.smartturn.exception.transfer.MapperException;
import co.org.smartturn.persistent.vo.VOProfile;
import co.org.smartturn.utils.Utilities;

/***
 * Clase que define un perfil de usuario.
 * 
 * @author joseanor
 *
 */
public final class DTOProfile extends ObjectMap implements Profile<Long>, MapEntity {

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
	private Long state;

	/**
	 * Usuario que creo el contacto.
	 */
	private Long creater;

	/**
	 * Usuario que realizo la ultima modificacion.
	 */
	private Long modifier;

	/**
	 * Codigo unico del usuario.
	 */
	private Long code;

	/**
	 * Role asociado al perfil.
	 */
	private Long role;
	
	
	@Override
	public java.util.Date getCreated() {
		return created;
	}

	@Override
	public void setCreated(Serializable created) {
		this.created = (java.util.Date) created;
	}

	@Override
	public java.util.Date getModified() {
		return modified;
	}

	@Override
	public void setModified(Serializable modified) {
		this.modified = (java.util.Date) modified;
	}

	@Override
	public Long getState() {
		return state;
	}

	@Override
	public void setState(Serializable state) {
		this.state = (Long)state;
	}

	@Override
	public Long getCreater() {
		return creater;
	}

	@Override
	public void setCreater(Serializable creater) {
		this.creater = (Long)creater;
	}

	@Override
	public Long getModifier() {
		return modifier;
	}

	@Override
	public void setModifier(Serializable modifier) {
		this.modifier = (Long)modifier;
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
	public Long getRole() {
		return role;
	}

	@Override
	public void setRole(Long role) {
		this.role = role;
	}

	@Override
	public int hashCode( ) {
		return code.hashCode();
	}
	
	@Override
	public boolean equals(Object object) {
		if(object == null || object.getClass() != this.getClass()) {
		   return false;
		}
		return (this.hashCode() == ((DTOProfile)object).hashCode());
	}
	
	@Override
	public Serializable get(Field field) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case PROFILE_CODE 		:  return getCode( );  
			case PROFILE_CREATED 	:  return getCreated( );  
			case PROFILE_CREATER 	:  return getCreater( );  
			case PROFILE_MODIFIED 	:  return getModified( );  
			case PROFILE_MODIFIER 	:  return getModifier( );  
			case PROFILE_STATE 		:  return getState( ); 
			case PROFILE_ROLE		:  return getRole( );
			default					:  return null;	
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Object> Class<T> type(Field field) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case PROFILE_CODE 		:  return (Class<T>) Utilities.getType(code		, Long.class);  
			case PROFILE_CREATED 	:  return (Class<T>) Utilities.getType(created	, java.util.Date.class);  
			case PROFILE_CREATER 	:  return (Class<T>) Utilities.getType(creater	, Long.class);  
			case PROFILE_MODIFIED 	:  return (Class<T>) Utilities.getType(modified	, java.util.Date.class);  
			case PROFILE_MODIFIER 	:  return (Class<T>) Utilities.getType(modifier	, Long.class);  
			case PROFILE_STATE 		:  return (Class<T>) Utilities.getType(state	, Long.class); 
			case PROFILE_ROLE		:  return (Class<T>) Utilities.getType(role		, Long.class);
			default					:  return null;	
		}
	}

	@Override
	public void put(Field field, Serializable value) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case PROFILE_CODE 		:  setCode( (long)value ); break; 
			case PROFILE_CREATED 	:  setCreated( value ); break; 
			case PROFILE_CREATER 	:  setCreater( value ); break; 
			case PROFILE_MODIFIED 	:  setModified( value ); break; 
			case PROFILE_MODIFIER 	:  setModifier( value ); break; 
			case PROFILE_STATE 		:  setState( value ); break;
			case PROFILE_ROLE		:  setRole( (Long)value ); break;
			default					:  break;	
		}
	}

	@Override
	public MapEntity map(Class<?> name, MapEntity source) throws MapperException {
		if(!name.getName().contains("Profile")) {
		   throw new MapperException("PER-45029", "No se puede hacer el mappeo, no hay compatibilidad en el objeto");	
		}
		Profile<Long> object = new VOProfile();
		object.put( ColumnFields.PROFILE_CODE 		, this.get(ColumnFields.PROFILE_CODE) );
		object.put( ColumnFields.PROFILE_CREATER 	, this.get(ColumnFields.PROFILE_CREATER) );
		object.put( ColumnFields.PROFILE_MODIFIER 	, this.get(ColumnFields.PROFILE_MODIFIER) );
		object.put( ColumnFields.PROFILE_STATE 		, this.get(ColumnFields.PROFILE_STATE) );
		object.put( ColumnFields.PROFILE_ROLE		, this.get(ColumnFields.PROFILE_ROLE) );
		object.put( ColumnFields.PROFILE_CREATED 	, Utilities.toSqlDate( (java.util.Date)this.get(ColumnFields.PROFILE_CREATED)) );
		object.put( ColumnFields.PROFILE_MODIFIED 	, Utilities.toSqlDate( (java.util.Date)this.get(ColumnFields.PROFILE_MODIFIED)) );
		return object;
	}
	
}
