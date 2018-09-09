package co.org.smartturn.data.transfer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import co.org.smartturn.data.model.User;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.adapter.DateAdapter;
import co.org.smartturn.data.transfer.fields.ColumnFields;
import co.org.smartturn.data.transfer.structure.ObjectMap;
import co.org.smartturn.exception.transfer.MapperException;
import co.org.smartturn.persistent.vo.VOProfile;
import co.org.smartturn.persistent.vo.VOUser;
import co.org.smartturn.utils.Utilities;

/**
 * Objeto que maneja la informacion del usuario.
 * 
 * @author joseanor
 *
 */
@XmlRootElement(name = "user")
public final class DTOUser extends ObjectMap implements User<DTOProfile> {

	private static final long serialVersionUID = 1L;

	/**
	 * Fecha de creacion.
	 */
	@XmlElement(name = "created")
    @XmlJavaTypeAdapter( DateAdapter.class )
	protected Date created;

	/**
	 * Fecha de modificacion.
	 */
	@XmlElement(name = "modified")
    @XmlJavaTypeAdapter( DateAdapter.class )
	protected Date modified;
	
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
	 * Perfiles de este usuario.
	 */
	private List<DTOProfile> profiles;

	/**
	 * Informacion del propietario de la cuenta
	 */
	private DTOContact contact;

	/**
	 * Clave del usuario
	 */
	private String password;

	/**
	 * Nombre de usuario (alias)
	 */
	private String username;


	@Override
	public Date getCreated() {
		return created;
	}

	@Override
	public void setCreated(Serializable created) {
		this.created = (Date) created;
	}

	@Override
	public Date getModified() {
		return modified;
	}

	@Override
	public void setModified(Serializable modified) {
		this.modified = (Date) modified;
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
	public long getCode() {
		return code;
	}

	@Override
	public void setCode(long code) {
		this.code = code;
	}

	@XmlElement(name = "contact")
	@Override
	public DTOContact getContact() {
		return contact;
	}

	@Override
	public void setContact(Serializable contact) {
		this.contact = (DTOContact)contact;
	}

	@Override
	public List<DTOProfile> getProfiles() {
		return profiles;
	}

	@Override
	public void setProfiles(List<DTOProfile> profiles) {
		this.profiles = profiles;
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
		return (this.hashCode() == ((DTOUser)object).hashCode());
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
			case USER_PROFILES		:  return (ArrayList<DTOProfile>)getProfiles( );
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
			case USER_PROFILES		:  setProfiles( (List<DTOProfile>)value ); break;
			default					:  break;	
		}	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Object> Class<T> type(Field field) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case USER_CODE 			:  return (Class<T>) Utilities.getType(code     , Long.class);  
			case USER_CREATED 		:  return (Class<T>) Utilities.getType(created  , Date.class);  
			case USER_CREATER 		:  return (Class<T>) Utilities.getType(creater  , Long.class);  
			case USER_MODIFIED 		:  return (Class<T>) Utilities.getType(modified , Date.class);  
			case USER_MODIFIER 		:  return (Class<T>) Utilities.getType(modifier , Long.class);  
			case USER_STATE 		:  return (Class<T>) Utilities.getType(state    , Long.class); 
			case USER_CONTACT		:  return (Class<T>) Utilities.getType(contact  , DTOContact.class);
			case USER_NAME 			:  return (Class<T>) Utilities.getType(username , String.class);
			case USER_PASSWD 		:  return (Class<T>) Utilities.getType(password , String.class);
			case USER_PROFILES		:  return (Class<T>) Utilities.getType(profiles , List.class);
			default					:  return null;	
		}
	}

	@Override
	public MapEntity map(Class<?> name, MapEntity source) throws MapperException {
		if(!name.getName().contains("User")) {
		   throw new MapperException("PER-45029", "No se puede hacer el mappeo, no hay compatibilidad en el objeto");	
		}
			User<VOProfile> object = null;
		try {
			object = new VOUser();
			object.put( ColumnFields.USER_CODE 		, this.get(ColumnFields.USER_CODE) );
			object.put( ColumnFields.USER_CREATER 	, this.get(ColumnFields.USER_CREATER) );
			object.put( ColumnFields.USER_MODIFIER 	, this.get(ColumnFields.USER_MODIFIER) );
			object.put( ColumnFields.USER_STATE 	, this.get(ColumnFields.USER_STATE) );
			object.put( ColumnFields.USER_NAME 		, this.get(ColumnFields.USER_NAME) );
			object.put( ColumnFields.USER_PASSWD 	, this.get(ColumnFields.USER_PASSWD) );
			object.put( ColumnFields.USER_CREATED 	, Utilities.toSqlDate( (java.util.Date)this.get(ColumnFields.USER_CREATED) ) );
			object.put( ColumnFields.USER_MODIFIED 	, Utilities.toSqlDate( (java.util.Date)this.get(ColumnFields.USER_MODIFIED) ) );
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
