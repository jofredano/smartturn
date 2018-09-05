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
			default				 :  return null;	
		}
	}

	@Override
	public void put(Field field, Serializable value) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case ACCESS_CODE 	 :  setCode( null ); break;
			case ACCESS_BEGIN 	 :  setBegin( null ); break;
			case ACCESS_END 	 :  setEnd( null ); break;
			case ACCESS_USER	 :  setUser( null ); break;
			case ACCESS_DURATION :  setDuration( null ); break;
			default				 :  break;
		}
	}

	@Override
	public MapEntity map(Class<?> name, MapEntity source) throws MapperException {
		return null;
	}

}
