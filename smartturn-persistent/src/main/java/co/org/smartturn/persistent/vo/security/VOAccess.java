package co.org.smartturn.persistent.vo.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import co.org.smartturn.data.model.security.Access;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.DTOUser;
import co.org.smartturn.data.transfer.fields.ColumnFields;
import co.org.smartturn.data.transfer.security.DTOAccess;
import co.org.smartturn.data.transfer.structure.ObjectMap;
import co.org.smartturn.exception.transfer.MapperException;
import co.org.smartturn.persistent.vo.VOUser;
import co.org.smartturn.utils.Utilities;

/**
 * Entidad que define la tabla acceso
 * 
 * @author joseanor
 *
 */
@Entity
@Table( name = "tb_accesos", schema = "smartturndb", uniqueConstraints = @UniqueConstraint(columnNames = { "codigo" }) )
public final class VOAccess extends ObjectMap implements Access<java.sql.Date, VOUser> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Representa el codigo del usuario modificador
	 */
	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;
	
	/**
	 * Representa el codigo del usuario modificador
	 */
	@Column(name = "token")
	private String token;
	
	/**
	 * Representa la fecha en que inicio la sesion
	 */
	@Column(name = "inicio")
	private java.sql.Date begin;
	
	/**
	 * Representa la fecha en que inicio la sesion
	 */
	@Column(name = "fin")
	private java.sql.Date end;

	/**
	 * Representa la informacion de contacto del usuario
	 */
	@ManyToOne
    @JoinColumn(name = "usuario")
	private VOUser user;
	
	/**
	 * Representa el codigo del usuario modificador
	 */
	@Column(name = "duracion")
	private Long duration;

	
	@Override
	public Long getCode() {
		return code;
	}

	@Override
	public void setCode(Long code) {
		this.code = code;
	}

	@Override
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String getToken() {
		return token;
	}

	@Override
	public java.sql.Date getBegin() {
		return begin;
	}

	@Override
	public void setBegin(java.sql.Date begin) {
		this.begin = begin;
	}

	@Override
	public java.sql.Date getEnd() {
		return end;
	}

	@Override
	public void setEnd(java.sql.Date end) {
		this.end = end;
	}

	@Override
	public void setUser(VOUser user) {
		this.user = user;
	}

	@Override
	public VOUser getUser() {
		return user;
	}

	@Override
	public Long getDuration() {
		return duration;
	}

	@Override
	public void setDuration(Long duration) {
		this.duration = duration;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Object> Class<T> type(Field field) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case ACCESS_CODE 	 :  return (Class<T>) Utilities.getType(code     , Long.class);  
			case ACCESS_DURATION :  return (Class<T>) Utilities.getType(duration , Long.class);  
			case ACCESS_BEGIN 	 :  return (Class<T>) Utilities.getType(begin    , java.sql.Date.class);  
			case ACCESS_END 	 :  return (Class<T>) Utilities.getType(end 	 , java.sql.Date.class);  
			case ACCESS_USER	 :  return (Class<T>) Utilities.getType(user  	 , VOUser.class);
			default				 :  return null;
		}
	}

	@Override
	public MapEntity map(Class<?> name, MapEntity source) throws MapperException {
		if(!name.getName().contains("Access")) {
		   throw new MapperException("PER-45029", "No se puede hacer el mappeo, no hay compatibilidad en el objeto");	
		}
			Access<java.util.Date, DTOUser> object = null;
		try {
			object = new DTOAccess();
			object.put( ColumnFields.ACCESS_DURATION  , this.get(ColumnFields.ACCESS_DURATION) );
			object.put( ColumnFields.ACCESS_CODE 	  , this.get(ColumnFields.ACCESS_CODE) );
			object.put( ColumnFields.ACCESS_BEGIN 	  , Utilities.toUtilDate( (java.sql.Date)this.get(ColumnFields.ACCESS_BEGIN) ) );
			object.put( ColumnFields.ACCESS_END 	  , Utilities.toUtilDate( (java.sql.Date)this.get(ColumnFields.ACCESS_END) ) );
			object.put( ColumnFields.ACCESS_USER	  , Utilities.getMapper(this, ColumnFields.ACCESS_USER, object.type(ColumnFields.ACCESS_USER)) );
			return object;
		} finally {
			if(object != null) {
			   object = null;	
			}
		}
	}

}
