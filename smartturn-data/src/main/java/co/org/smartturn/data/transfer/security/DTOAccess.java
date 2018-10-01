package co.org.smartturn.data.transfer.security;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import co.org.smartturn.data.model.security.Access;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.DTOUser;
import co.org.smartturn.data.transfer.adapter.DateAdapter;
import co.org.smartturn.data.transfer.fields.ColumnFields;
import co.org.smartturn.data.transfer.structure.ObjectMap;
import co.org.smartturn.domain.vo.VOAccess;
import co.org.smartturn.domain.vo.VOUser;
import co.org.smartturn.exception.transfer.MapperException;
import co.org.smartturn.utils.Utilities;

/**
 * Representa la informacion de acceso al sistema de un usuario. 
 *
 * @author joseanor
 *
 */
@XmlRootElement
public final class DTOAccess extends ObjectMap implements Access<java.util.Date, DTOUser> {

	private static final long serialVersionUID = 1L;

	/**
	 * Codigo del acceso
	 */
	private Long code;
	
	/**
	 * Nombre de usuario usado
	 */
	private Long duration;
	
	/**
	 * Nombre de usuario usado
	 */
	private DTOUser user;

	/**
	 * Codigo de acceso otorgado por el sistema.
	 */
	private String token;
	
	/**
	 * Fecha de inicio del acceso
	 */
	private java.util.Date begin;
	
	/**
	 * Fecha de inicio del acceso
	 */
	private java.util.Date end;


	@Override
	public void setToken(String token) {
		this.token = token;
	}

	@XmlElement(name = "token")
	@Override
	public String getToken() {
		return token;
	}

	@XmlElement(name = "begin")
	@XmlJavaTypeAdapter( DateAdapter.class )
	@Override
	public java.util.Date getBegin() {
		return begin;
	}

	@Override
	public void setBegin(java.util.Date begin) {
		this.begin = begin;
	}

	@XmlElement(name = "end")
	@XmlJavaTypeAdapter( DateAdapter.class )
	@Override
	public java.util.Date getEnd() {
		return end;
	}

	@Override
	public void setEnd(java.util.Date end) {
		this.end = end;
	}

	@Override
	public void setUser(DTOUser user) {
		this.user = user;
	}

	@XmlElement(name = "user")
	@Override
	public DTOUser getUser() {
		return user;
	}

	@XmlElement(name = "duration")
	@Override
	public Long getDuration() {
		return duration;
	}

	@Override
	public void setDuration(Long duration) {
		this.duration = duration;
	}

	@XmlElement(name = "code")
	@Override
	public Long getCode() {
		return code;
	}

	@Override
	public void setCode(Long code) {
		this.code = code;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Object> Class<T> type(Field field) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case ACCESS_CODE 	 :  return (Class<T>) Utilities.getType(code     , Long.class);  
			case ACCESS_DURATION :  return (Class<T>) Utilities.getType(duration , Long.class);  
			case ACCESS_BEGIN 	 :  return (Class<T>) Utilities.getType(begin    , java.util.Date.class);  
			case ACCESS_END 	 :  return (Class<T>) Utilities.getType(end 	 , java.util.Date.class);  
			case ACCESS_USER	 :  return (Class<T>) Utilities.getType(user  	 , DTOUser.class);
			case ACCESS_TOKEN    :  return (Class<T>) Utilities.getType(token  	 , String.class);
			default				 :  return null;
		}
	}
	
	@Override
	public Serializable get(Field field) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case ACCESS_CODE 	 :  return getCode( );  
			case ACCESS_BEGIN 	 :  return getBegin( );  
			case ACCESS_END 	 :  return getEnd( );  
			case ACCESS_USER	 :  return getUser( );
			case ACCESS_DURATION :  return getDuration( );
			case ACCESS_TOKEN    :  return getToken();
			default				 :  return null;	
		}
	}

	@Override
	public void put(Field field, Serializable value) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case ACCESS_CODE 	 :  setCode( (Long)value ); break;
			case ACCESS_BEGIN 	 :  setBegin( (java.util.Date)value ); break;
			case ACCESS_END 	 :  setEnd( (java.util.Date)value ); break;
			case ACCESS_USER	 :  setUser( (DTOUser)value ); break;
			case ACCESS_DURATION :  setDuration( (Long)value ); break;
			case ACCESS_TOKEN    :  setToken( (String)value ); break;
			default				 :  break;
		}
	}

	@Override
	public MapEntity map(Class<?> name, MapEntity source) throws MapperException {
		if(!name.getName().contains("Access")) {
		   throw new MapperException("PER-45029", "No se puede hacer el mappeo, no hay compatibilidad en el objeto");	
		}
			Access<java.sql.Date, VOUser> object = null;
		try {
			object = new VOAccess();
			object.put( ColumnFields.ACCESS_TOKEN     , this.get(ColumnFields.ACCESS_TOKEN));
			object.put( ColumnFields.ACCESS_DURATION  , this.get(ColumnFields.ACCESS_DURATION) );
			object.put( ColumnFields.ACCESS_CODE 	  , this.get(ColumnFields.ACCESS_CODE) );
			object.put( ColumnFields.ACCESS_BEGIN 	  , Utilities.toSqlDate( (java.util.Date)this.get(ColumnFields.ACCESS_BEGIN) ) );
			object.put( ColumnFields.ACCESS_END 	  , Utilities.toSqlDate( (java.util.Date)this.get(ColumnFields.ACCESS_END) ) );
			object.put( ColumnFields.ACCESS_USER	  , Utilities.getMapper(this, ColumnFields.ACCESS_USER, object.type(ColumnFields.ACCESS_USER)) );
			return object;
		} finally {
			if(object != null) {
			   object = null;
			}
		}
	}

}
