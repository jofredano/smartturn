package co.org.smartturn.domain.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import co.org.smartturn.data.model.User;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.DTOProfile;
import co.org.smartturn.data.transfer.DTOUser;
import co.org.smartturn.data.transfer.fields.ColumnFields;
import co.org.smartturn.data.transfer.structure.ObjectMap;
import co.org.smartturn.exception.transfer.MapperException;
import co.org.smartturn.utils.Utilities;

/**
 * Objeto que representa en base de datos un usuario.
 * 
 * @author joseanor
 *
 */
@Entity
@Table(name = "tb_usuarios", schema = "smartturndb", 
 uniqueConstraints = @UniqueConstraint(columnNames = { "codigo" }) 
)
public class VOUser extends ObjectMap implements User<VOProfile> {

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
	 * Representa el codigo del usuario modificador
	 */
	@Column(name = "alias")
	private String username;
	
	/**
	 * Representa el codigo del usuario modificador
	 */
	@Column(name = "clave")
	private String password;

	/**
	 * Representa la informacion de contacto del usuario
	 */
	@ManyToOne
    @JoinColumn(name = "contacto")
	private VOContact contact;

	/**
	 * Perfiles de este usuario.
	 */
	@OneToMany(fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "usuario", referencedColumnName = "codigo")
	private List<VOProfile> profiles;
	
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
	public Serializable getCreater() {
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
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Serializable getContact() {
		return contact;
	}

	@Override
	public void setContact(Serializable contact) {
		this.contact = (VOContact)contact;
	}

	@Override
	public List<VOProfile> getProfiles() {
		return profiles;
	}

	@Override
	public void setProfiles(List<VOProfile> profiles) {
		this.profiles = profiles;
	}

	@Override
	public Serializable get(Field field) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case USER_CODE 			:  return getCode( );  
			case USER_CREATED 		:  return getCreated( );  
			case USER_CREATER 		:  return getCreater( );  
			case USER_MODIFIED 		:  return getModified( );  
			case USER_MODIFIER 		:  return getModifier( );  
			case USER_STATE 		:  return getState( ); 
			case USER_CONTACT		:  return getContact( );
			case USER_NAME 			:  return getUsername( );
			case USER_PASSWD 		:  return getPassword( );
			case USER_PROFILES		:  return (ArrayList<VOProfile>)getProfiles( );
			default					:  return null;	
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void put(Field field, Serializable value) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case USER_CODE 			:  setCode( (long)value ); break; 
			case USER_CREATED 		:  setCreated( value ); break; 
			case USER_CREATER 		:  setCreater( value ); break; 
			case USER_MODIFIED 		:  setModified( value ); break; 
			case USER_MODIFIER 		:  setModifier( value ); break; 
			case USER_STATE 		:  setState( value ); break;
			case USER_CONTACT		:  setContact( value ); break;
			case USER_NAME 			:  setUsername( (String)value ); break;
			case USER_PASSWD 		:  setPassword( (String)value ); break;
			case USER_PROFILES		:  setProfiles( (List<VOProfile>)value ); break;
			default					:  break;	
		}	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Object> Class<T> type(Field field) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case USER_CODE 			:  return (Class<T>) Utilities.getType(code     , Long.class);  
			case USER_CREATED 		:  return (Class<T>) Utilities.getType(created  , java.sql.Date.class);  
			case USER_CREATER 		:  return (Class<T>) Utilities.getType(creater  , Long.class);  
			case USER_MODIFIED 		:  return (Class<T>) Utilities.getType(modified , java.sql.Date.class);  
			case USER_MODIFIER 		:  return (Class<T>) Utilities.getType(modifier , Long.class);  
			case USER_STATE 		:  return (Class<T>) Utilities.getType(state    , Long.class); 
			case USER_CONTACT		:  return (Class<T>) Utilities.getType(contact  , VOContact.class);
			case USER_NAME 			:  return (Class<T>) Utilities.getType(username , String.class);
			case USER_PASSWD 		:  return (Class<T>) Utilities.getType(password , String.class);
			case USER_PROFILES		:  return (Class<T>) Utilities.getType(profiles , List.class);
			default					:  return null;	
		}
	}

	@Override
	public User<DTOProfile> map(Class<?> name, MapEntity source) throws MapperException {
		if(!name.getName().contains("User")) {
		   throw new MapperException("PER-45029", "No se puede hacer el mappeo, no hay compatibilidad en el objeto");	
		}
			User<DTOProfile> object = null;
		try {
			object = new DTOUser();
			object.put( ColumnFields.USER_CODE 		, this.get(ColumnFields.USER_CODE) );
			object.put( ColumnFields.USER_CREATER 	, this.get(ColumnFields.USER_CREATER) );
			object.put( ColumnFields.USER_MODIFIER 	, this.get(ColumnFields.USER_MODIFIER) );
			object.put( ColumnFields.USER_STATE 	, this.get(ColumnFields.USER_STATE) );
			object.put( ColumnFields.USER_NAME 		, this.get(ColumnFields.USER_NAME) );
			object.put( ColumnFields.USER_PASSWD 	, this.get(ColumnFields.USER_PASSWD) );
			object.put( ColumnFields.USER_CREATED 	, Utilities.toUtilDate( (java.sql.Date)this.get(ColumnFields.USER_CREATED) ) );
			object.put( ColumnFields.USER_MODIFIED 	, Utilities.toUtilDate( (java.sql.Date)this.get(ColumnFields.USER_MODIFIED) ) );
			object.put( ColumnFields.USER_CONTACT	, Utilities.getMapper(this, ColumnFields.USER_CONTACT, object.type(ColumnFields.USER_CONTACT)) );
			object.put( ColumnFields.USER_PROFILES	, (Serializable) Utilities.toArray(profiles, DTOProfile.class) );
			return object;			
		} finally {
			if(object != null) {
			   object = null;	
			}
		}
	}
}
