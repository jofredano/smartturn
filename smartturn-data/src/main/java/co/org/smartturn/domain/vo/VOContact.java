package co.org.smartturn.domain.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import co.org.smartturn.data.model.Contact;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.DTOContact;
import co.org.smartturn.data.transfer.DTOReference;
import co.org.smartturn.data.transfer.fields.ColumnFields;
import co.org.smartturn.data.transfer.structure.ObjectMap;
import co.org.smartturn.exception.transfer.MapperException;
import co.org.smartturn.utils.Utilities;

/**
 * Objeto que representa en base de datos un contacto.
 * 
 * @author joseanor
 *
 */
@Entity
@Table(name = "tb_contactos", schema = "smartturndb", 
 uniqueConstraints = @UniqueConstraint(columnNames = { "codigo" }) )
public class VOContact extends ObjectMap implements Contact<VOReference> {

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
	 * Representa el tipo de contacto
	 */
	@Column(name = "tipo")
	private Long type;	
	
	/**
	 * Representa la identificacion del contacto
	 */
	@Column(name = "identificacion")
	private String identification;

	/**
	 * Representa el primer nombre
	 */
	@Column(name = "primer_nombre")
	private String firstname;

	/**
	 * Representa el segundo nombre
	 */
	@Column(name = "segundo_nombre")
	private String secondname;

	/**
	 * Representa el primer apellido
	 */
	@Column(name = "primer_apellido")
	private String firstLastname;

	/**
	 * Representa el segundo apellido
	 */
	@Column(name = "segundo_apellido")
	private String secondLastname;

	/**
	 * Representa el segundo apellido
	 */
	@Column(name = "nacimiento")
	private java.sql.Date birth;

	/**
	 * Representa la lista de referencias que puede tener este contacto
	 */
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "contacto", referencedColumnName = "codigo")
	private List<VOReference> references;

	@Override
	public long getCode() {
		return code;
	}

	@Override
	public void setCode(long code) {
		this.code = code;
	}

	@Override
	public Long getType() {
		return type;
	}

	@Override
	public void setType(Serializable type) {
		this.type = (Long)type;
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
	public String getIdentification() {
		return identification;
	}

	@Override
	public void setIdentification(Serializable identification) {
		this.identification = (String)identification;
	}

	@Override
	public String getFirstname() {
		return firstname;
	}

	@Override
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String getSecondname() {
		return secondname;
	}

	@Override
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	@Override
	public String getFirstLastname() {
		return firstLastname;
	}

	@Override
	public void setFirstLastname(String firstLastname) {
		this.firstLastname = firstLastname;
	}

	@Override
	public String getSecondLastname() {
		return secondLastname;
	}

	@Override
	public void setSecondLastname(String secondLastname) {
		this.secondLastname = secondLastname;
	}

	@Override
	public java.sql.Date getBirth() {
		return birth;
	}

	@Override
	public void setBirth(Serializable birth) {
		this.birth = (java.sql.Date)birth;
	}

	@Override
	public List<VOReference> getReferences() {
		return references;
	}

	@Override
	public void setReferences(List<VOReference> references) {
		this.references = references;
	}

	@Override
	public Serializable get(Field field) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case CONTACT_FIRSTNAME  	:  return getFirstname( );  
			case CONTACT_SECONDNAME 	:  return getSecondname( );  
			case CONTACT_FIRSTLASTNAME 	:  return getFirstLastname( );  
			case CONTACT_SECONDLASTNAME :  return getSecondLastname( );  
			case CONTACT_IDENTIFICATION :  return getIdentification( );  
			case CONTACT_CODE 			:  return getCode( );  
			case CONTACT_REFERENCES 	:  return (Serializable) getReferences();  
			case CONTACT_CREATED 		:  return getCreated( );  
			case CONTACT_CREATER 		:  return getCreater( );  
			case CONTACT_MODIFIED 		:  return getModified( );  
			case CONTACT_MODIFIER 		:  return getModifier( );  
			case CONTACT_TYPE 			:  return getType(  );  
			case CONTACT_BIRTHDAY 		:  return getBirth( );  
			case CONTACT_STATE 			:  return getState( ); 
			default						:  return null;	
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void put(Field field, Serializable value) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case CONTACT_FIRSTNAME  	:  setFirstname( (String)value );  break; 
			case CONTACT_SECONDNAME 	:  setSecondname( (String)value ); break; 
			case CONTACT_FIRSTLASTNAME 	:  setFirstLastname( (String)value ); break; 
			case CONTACT_SECONDLASTNAME :  setSecondLastname( (String)value ); break; 
			case CONTACT_IDENTIFICATION :  setIdentification( value ); break; 
			case CONTACT_CODE 			:  setCode( (long)value ); break; 
			case CONTACT_REFERENCES 	:  setReferences( (ArrayList<VOReference>)value ); break; 
			case CONTACT_CREATED 		:  setCreated( value ); break; 
			case CONTACT_CREATER 		:  setCreater( value ); break; 
			case CONTACT_MODIFIED 		:  setModified( value ); break; 
			case CONTACT_MODIFIER 		:  setModifier( value ); break; 
			case CONTACT_TYPE 			:  setType( value ); break; 
			case CONTACT_BIRTHDAY 		:  setBirth( value); break; 
			case CONTACT_STATE 			:  setState( value ); break;
			default: break;	
		}
	}

	@Override
	public Contact<DTOReference> map(Class<?> name, MapEntity source) throws MapperException {
		if(!name.getName().contains("Contact")) {
		   throw new MapperException("PER-45029", "No se puede hacer el mappeo, no hay compatibilidad en el objeto");	
		}
		Contact<DTOReference> object = new DTOContact();
		object.put( ColumnFields.CONTACT_FIRSTNAME  	, this.get(ColumnFields.CONTACT_FIRSTNAME) );
		object.put( ColumnFields.CONTACT_SECONDNAME 	, this.get(ColumnFields.CONTACT_SECONDNAME) );
		object.put( ColumnFields.CONTACT_FIRSTLASTNAME 	, this.get(ColumnFields.CONTACT_FIRSTLASTNAME) );
		object.put( ColumnFields.CONTACT_SECONDLASTNAME , this.get(ColumnFields.CONTACT_SECONDLASTNAME) );
		object.put( ColumnFields.CONTACT_IDENTIFICATION , this.get(ColumnFields.CONTACT_IDENTIFICATION) );
		object.put( ColumnFields.CONTACT_CODE 			, this.get(ColumnFields.CONTACT_CODE) );
		object.put( ColumnFields.CONTACT_CREATER 		, this.get(ColumnFields.CONTACT_CREATER) );
		object.put( ColumnFields.CONTACT_MODIFIER 		, this.get(ColumnFields.CONTACT_MODIFIER) );
		object.put( ColumnFields.CONTACT_TYPE 			, this.get(ColumnFields.CONTACT_TYPE) );
		object.put( ColumnFields.CONTACT_STATE 			, this.get(ColumnFields.CONTACT_STATE) );
		object.put( ColumnFields.CONTACT_CREATED 		, Utilities.toUtilDate( (java.sql.Date)this.get(ColumnFields.CONTACT_CREATED) ) );
		object.put( ColumnFields.CONTACT_MODIFIED 		, Utilities.toUtilDate( (java.sql.Date)this.get(ColumnFields.CONTACT_MODIFIED) ) );
		object.put( ColumnFields.CONTACT_BIRTHDAY 		, Utilities.toUtilDate( (java.sql.Date)this.get(ColumnFields.CONTACT_BIRTHDAY) ) );
		object.put( ColumnFields.CONTACT_REFERENCES 	, (Serializable) Utilities.toArray(references, DTOReference.class) );
		return object;
	}

}
