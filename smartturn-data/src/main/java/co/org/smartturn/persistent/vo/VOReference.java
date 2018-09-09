package co.org.smartturn.persistent.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import co.org.smartturn.data.model.Reference;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
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
@Table(name = "tb_referencias", schema = "smartturndb", 
 uniqueConstraints = @UniqueConstraint(columnNames = { "codigo" }) )
public class VOReference extends ObjectMap implements Reference {

	private static final long serialVersionUID = 1L;

	/**
	 * Representa el codigo del perfil
	 */
	@Id
	@Column(name = "codigo")
	private Long code;
	
	/**
	 * Representa la fecha en que fue creada la referencia
	 */
	@Column(name = "creado")
	private java.sql.Date created;
	
	/**
	 * Representa la fecha en que fue modificada la referencia
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
	 * Representa el tipo de la referencia
	 */
	@Column(name = "tipo")
	private Long type;
	
	/**
	 * Representa la categoria de la referencia
	 */
	@Column(name = "categoria")
	private Long category;
	
	/**
	 * Representa si tiene preferencia la referencia
	 */
	@Column(name = "preferencia")
	private Boolean preference;
	
	/**
	 * Representa el valor de la referencia
	 */
	@Column(name = "referencia")
	private String value;
	
	/**
	 * Informacion del contacto
	 */
	@Column(name = "contacto")
	private Long contact;
	

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
	public Long getCategory() {
		return category;
	}

	@Override
	public void setCategory(Serializable category) {
		this.category = (Long)category;
	}

	@Override
	public boolean isPreference() {
		return preference;
	}

	@Override
	public void setPreference(boolean preference) {
		this.preference = preference;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public Long getContact() {
		return contact;
	}
	
	@Override
	public void setContact(Long contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "VOReference [code=" + code + ", created=" + created + ", modified=" + modified + ", state=" + state
				+ ", creater=" + creater + ", modifier=" + modifier + ", type=" + type + ", category=" + category
				+ ", preference=" + preference + ", value=" + value + ", contact=" + contact + "]";
	}

	@Override
	public Serializable get(Field field) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case REFERENCE_CODE 			:  return getCode( );  
			case REFERENCE_CREATED 			:  return getCreated( );  
			case REFERENCE_CREATER 			:  return getCreater( );  
			case REFERENCE_MODIFIED 		:  return getModified( );  
			case REFERENCE_MODIFIER 		:  return getModifier( );  
			case REFERENCE_TYPE 			:  return getType(  );  
			case REFERENCE_STATE 			:  return getState( ); 
			case REFERENCE_CATEGORY 		:  return getCategory( );  
			case REFERENCE_VALUE 			:  return getValue( );
			case REFERENCE_PREFERENCE		:  return isPreference( );
			default							:  return null;	
		}
	}

	@Override
	public void put(Field field, Serializable value) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case REFERENCE_CODE 			:  setCode( (long)value ); break; 
			case REFERENCE_CREATED 			:  setCreated( value ); break; 
			case REFERENCE_CREATER 			:  setCreater( value ); break; 
			case REFERENCE_MODIFIED 		:  setModified( value ); break; 
			case REFERENCE_MODIFIER 		:  setModifier( value ); break; 
			case REFERENCE_TYPE 			:  setType( value ); break; 
			case REFERENCE_STATE 			:  setState( value ); break;
			case REFERENCE_CATEGORY 		:  setCategory ( value ); break;
			case REFERENCE_VALUE 			:  setValue( (String)value ); break; 
			case REFERENCE_PREFERENCE 		:  setPreference ( (boolean)value ); break;
			default							:  break;	
		}
	}

	@Override
	public Reference map(Class<?> name, MapEntity source) throws MapperException {
		if(!name.getName().contains("Reference")) {
		   throw new MapperException("PER-45029", "No se puede hacer el mappeo, no hay compatibilidad en el objeto");	
		}
		Reference object = new DTOReference();
		object.put( ColumnFields.REFERENCE_CODE			, this.get(ColumnFields.REFERENCE_CODE) );
		object.put( ColumnFields.REFERENCE_TYPE 		, this.get(ColumnFields.REFERENCE_TYPE) );
		object.put( ColumnFields.REFERENCE_CATEGORY 	, this.get(ColumnFields.REFERENCE_CATEGORY) );
		object.put( ColumnFields.REFERENCE_VALUE 		, this.get(ColumnFields.REFERENCE_VALUE) );
		object.put( ColumnFields.REFERENCE_PREFERENCE   , this.get(ColumnFields.REFERENCE_PREFERENCE) );
		object.put( ColumnFields.REFERENCE_STATE 		, this.get(ColumnFields.REFERENCE_STATE) );
		object.put( ColumnFields.REFERENCE_CREATER 		, this.get(ColumnFields.REFERENCE_CREATER) );
		object.put( ColumnFields.REFERENCE_MODIFIER 	, this.get(ColumnFields.REFERENCE_MODIFIER) );
		object.put( ColumnFields.REFERENCE_CREATED 		, Utilities.toUtilDate( (java.sql.Date)this.get(ColumnFields.REFERENCE_CREATED) ) );
		object.put( ColumnFields.REFERENCE_MODIFIED 	, Utilities.toUtilDate( (java.sql.Date)this.get(ColumnFields.REFERENCE_MODIFIED) ) );
		return object;
	}

}
