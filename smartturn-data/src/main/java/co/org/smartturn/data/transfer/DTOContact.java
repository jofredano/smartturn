package co.org.smartturn.data.transfer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import co.org.smartturn.data.model.Contact;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.adapter.DateAdapter;
import co.org.smartturn.data.transfer.fields.ColumnFields;
import co.org.smartturn.data.transfer.structure.DTODocument;
import co.org.smartturn.data.transfer.structure.ObjectMap;
import co.org.smartturn.exception.transfer.MapperException;
import co.org.smartturn.persistent.vo.VOContact;
import co.org.smartturn.persistent.vo.VOReference;
import co.org.smartturn.utils.Utilities;

/**
 * Implementacion del objeto contacto.
 * 
 * @author joseanor
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "contact", propOrder = {
		"code",
		"type",
		"identification",
		"firstname",
		"secondname",
		"firstLastname",
		"secondLastname",
		"created", 
		"modified",
		"birth",
		"state",
		"creater",
		"modifier",
		"references"})
public final class DTOContact extends ObjectMap implements Contact<DTOReference> {

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
	 * Fecha de nacimiento.
	 */
	@XmlElement(name = "birth")
    @XmlJavaTypeAdapter( DateAdapter.class )
	private java.util.Date birth;

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
	 * Codigo unico del contacto.
	 */
	private Long code;

	/**
	 * Tipo de contacto.
	 */
	private Long type;

	/**
	 * Identificacion del contacto.
	 */
	private DTODocument identification;

	/**
	 * Primer nombre.
	 */
	private String firstname;

	/**
	 * Segundo nombre.
	 */
	private String secondname;

	/**
	 * Primer apellido.
	 */
	private String firstLastname;

	/**
	 * Segundo apellido.
	 */
	private String secondLastname;

	/**
	 * Referencias del contacto.
	 */
	@XmlElement(name = "references")
	private List<DTOReference> references;

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
	public Serializable getState() {
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
		this.creater = (Long) creater;
	}

	@Override
	public Serializable getModifier() {
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
	public Long getType() {
		return type;
	}

	@Override
	public void setType(Serializable type) {
		this.type = (Long)type;
	}

	@Override
	public DTODocument getIdentification() {
		return identification;
	}

	@Override
	public void setIdentification(Serializable identification) {
		if(identification instanceof String) {
		   identification   = DTODocument.valueOf((String)identification);	
		}
		this.identification = (DTODocument) identification;
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
	public Serializable getBirth() {
		return birth;
	}

	@Override
	public void setBirth(Serializable birth) {
		this.birth = (Date) birth;
	}

	@Override
	public List<DTOReference> getReferences() {
		return references;
	}

	@Override
	public void setReferences(List<DTOReference> references) {
		this.references = references;
	}
	
	@Override
	public int hashCode( ) {
		return  code.hashCode() + identification.hashCode();
	}
	
	@Override
	public boolean equals(Object object) {
		if(object == null || object.getClass() != this.getClass()) {
		   return false;
		}
		return (this.hashCode() == ((DTOContact)object).hashCode());
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
			case CONTACT_REFERENCES 	:  return (Serializable) getReferences( );  
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
	public <T extends Object> Class<T> type(Field field) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case CONTACT_FIRSTNAME  	:  return (Class<T>) Utilities.getType(firstname		, String.class);  
			case CONTACT_SECONDNAME 	:  return (Class<T>) Utilities.getType(secondname		, String.class);  
			case CONTACT_FIRSTLASTNAME 	:  return (Class<T>) Utilities.getType(firstLastname	, String.class);  
			case CONTACT_SECONDLASTNAME :  return (Class<T>) Utilities.getType(secondLastname	, String.class);  
			case CONTACT_IDENTIFICATION :  return (Class<T>) Utilities.getType(identification	, DTODocument.class);  
			case CONTACT_CODE 			:  return (Class<T>) Utilities.getType(code				, Long.class);  
			case CONTACT_REFERENCES 	:  return (Class<T>) Utilities.getType(references		, List.class);  
			case CONTACT_CREATED 		:  return (Class<T>) Utilities.getType(created			, Date.class);  
			case CONTACT_CREATER 		:  return (Class<T>) Utilities.getType(creater 			, Long.class);  
			case CONTACT_MODIFIED 		:  return (Class<T>) Utilities.getType(modified			, Date.class);  
			case CONTACT_MODIFIER 		:  return (Class<T>) Utilities.getType(modifier 		, Long.class);  
			case CONTACT_TYPE 			:  return (Class<T>) Utilities.getType(type				, Long.class);  
			case CONTACT_BIRTHDAY 		:  return (Class<T>) Utilities.getType(birth			, Date.class);  
			case CONTACT_STATE 			:  return (Class<T>) Utilities.getType(state			, Long.class); 
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
			case CONTACT_REFERENCES 	:  setReferences( (List<DTOReference>)value ); break; 
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
	public MapEntity map(Class<?> name, MapEntity source) throws MapperException {
		if(!name.getName().contains("Contact")) {
		   throw new MapperException("PER-45029", "No se puede hacer el mappeo, no hay compatibilidad en el objeto");	
		}
		Contact<VOReference> object = new VOContact();
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
		object.put( ColumnFields.CONTACT_CREATED 		, Utilities.toSqlDate( (java.util.Date)this.get(ColumnFields.CONTACT_CREATED) ) );
		object.put( ColumnFields.CONTACT_MODIFIED 		, Utilities.toSqlDate( (java.util.Date)this.get(ColumnFields.CONTACT_MODIFIED) ) );
		object.put( ColumnFields.CONTACT_BIRTHDAY 		, Utilities.toSqlDate( (java.util.Date)this.get(ColumnFields.CONTACT_BIRTHDAY) ) );
		object.put( ColumnFields.CONTACT_REFERENCES 	, (Serializable) Utilities.toArray(references, VOReference.class) );
		return object;
	}

}
