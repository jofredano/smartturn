package co.org.smartturn.persistent.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import co.org.smartturn.data.model.Profile;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.DTOProfile;
import co.org.smartturn.data.transfer.fields.ColumnFields;
import co.org.smartturn.data.transfer.structure.ObjectMap;
import co.org.smartturn.exception.transfer.MapperException;
import co.org.smartturn.utils.Utilities;

/**
 * Objeto que representa en base de datos un perfil.
 * 
 * @author joseanor
 *
 */
@Entity
@Table(name = "tb_perfiles", schema = "smartturndb", 
 uniqueConstraints = @UniqueConstraint(columnNames = { "codigo" }) 
)
public class VOProfile extends ObjectMap implements Profile<Long> {

	private static final long serialVersionUID = 1L;

	/**
	 * Representa el codigo del perfil
	 */
	@Id
	@Column(name = "codigo")
	private Long code;
	
	/**
	 * Representa la fecha en que fue creado el perfil
	 */
	@Column(name = "creado")
	private java.sql.Date created;
	
	/**
	 * Representa la fecha en que fue modificado el perfil
	 */
	@Column(name = "modificado")
	private java.sql.Date modified;

	/**
	 * Representa el estado del perfil
	 */
	@Column(name = "estado")
	private Long state;
	
	/**
	 * Representa el codigo del usuario creador
	 */
	@Column(name = "creador")
	private Long creater;
	
	/**
	 * Representa el codigo del usuario modificador
	 */
	@Column(name = "modificador")
	private Long modifier;

	/**
	 * Representa el rol asociado al perfil
	 */
	@Column(name = "perfil")
	private Long role;

	@Override
	public long getCode() {
		return code;
	}

	@Override
	public void setCode(long code) {
		this.code = code;
	}
	
	@Override
	public java.sql.Date getCreated() {
		return created;
	}

	@Override
	public void setCreated(Serializable created) {
		this.created = (java.sql.Date)created;
	}

	@Override
	public java.sql.Date getModified() {
		return modified;
	}

	@Override
	public void setModified(Serializable modified) {
		this.modified = (java.sql.Date)modified;
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
	public Long getRole() {
		return role;
	}

	@Override
	public void setRole(Long role) {
		this.role = role;
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
	public Profile<Long> map(Class<?> name, MapEntity source) throws MapperException {
		if(!name.getName().contains("Profile")) {
		   throw new MapperException("PER-45029", "No se puede hacer el mappeo, no hay compatibilidad en el objeto");	
		}
		Profile<Long> object = new DTOProfile();
		object.put( ColumnFields.PROFILE_CODE 		, this.get(ColumnFields.PROFILE_CODE) );
		object.put( ColumnFields.PROFILE_CREATER 	, this.get(ColumnFields.PROFILE_CREATER) );
		object.put( ColumnFields.PROFILE_MODIFIER 	, this.get(ColumnFields.PROFILE_MODIFIER) );
		object.put( ColumnFields.PROFILE_STATE 		, this.get(ColumnFields.PROFILE_STATE) );
		object.put( ColumnFields.PROFILE_ROLE		, this.get(ColumnFields.PROFILE_ROLE) );
		object.put( ColumnFields.PROFILE_CREATED 	, Utilities.toUtilDate( (java.sql.Date)this.get(ColumnFields.PROFILE_CREATED)) );
		object.put( ColumnFields.PROFILE_MODIFIED 	, Utilities.toUtilDate( (java.sql.Date)this.get(ColumnFields.PROFILE_MODIFIED)) );
		return object;
	}
}
