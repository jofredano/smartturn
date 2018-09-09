package co.org.smartturn.data.transfer;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import co.org.smartturn.data.model.Reference;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.adapter.DateAdapter;
import co.org.smartturn.data.transfer.fields.ColumnFields;
import co.org.smartturn.data.transfer.structure.ObjectMap;
import co.org.smartturn.exception.transfer.MapperException;
import co.org.smartturn.persistent.vo.VOReference;
import co.org.smartturn.utils.Utilities;

/**
 * Implementacion del objeto de referencia.
 * 
 * @author joseanor
 *
 */
@XmlRootElement(name = "reference")
public final class DTOReference extends ObjectMap implements Reference, MapEntity {

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
	 * Codigo unico del contacto.
	 */
	private long code;

	/**
	 * Tipo de referencia.
	 */
	private Long type;

	/**
	 * Valor de la referencia
	 */
	private String value;

	/**
	 * Si este contacto tiene preferencia.
	 */
	private boolean preference;

	/**
	 * Categoria de la referencia.
	 */
	private Long category;
	
	/**
	 * Referencia del contacto
	 */
	private Long contact;
	
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
	public int hashCode( ) {
		return  (Long.valueOf(code)).hashCode();
	}
	
	@Override
	public boolean equals(Object object) {
		if(object == null || object.getClass() != this.getClass()) {
		   return false;
		}
		return (this.hashCode() == ((DTOReference)object).hashCode());
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
	public MapEntity map(Class<?> name, MapEntity source) throws MapperException {
		if(!name.getName().contains("Reference")) {
		   throw new MapperException("PER-45029", "No se puede hacer el mappeo, no hay compatibilidad en el objeto");	
		}
		Reference object = new VOReference();
		object.put( ColumnFields.REFERENCE_CODE			, this.get(ColumnFields.REFERENCE_CODE) );
		object.put( ColumnFields.REFERENCE_TYPE 		, this.get(ColumnFields.REFERENCE_TYPE) );
		object.put( ColumnFields.REFERENCE_CATEGORY 	, this.get(ColumnFields.REFERENCE_CATEGORY) );
		object.put( ColumnFields.REFERENCE_VALUE 		, this.get(ColumnFields.REFERENCE_VALUE) );
		object.put( ColumnFields.REFERENCE_PREFERENCE   , this.get(ColumnFields.REFERENCE_PREFERENCE) );
		object.put( ColumnFields.REFERENCE_STATE 		, this.get(ColumnFields.REFERENCE_STATE) );
		object.put( ColumnFields.REFERENCE_CREATER 		, this.get(ColumnFields.REFERENCE_CREATER) );
		object.put( ColumnFields.REFERENCE_MODIFIER 	, this.get(ColumnFields.REFERENCE_MODIFIER) );
		object.put( ColumnFields.REFERENCE_CREATED 		, Utilities.toSqlDate( (java.util.Date)this.get(ColumnFields.REFERENCE_CREATED) ) );
		object.put( ColumnFields.REFERENCE_MODIFIED 	, Utilities.toSqlDate( (java.util.Date)this.get(ColumnFields.REFERENCE_MODIFIED) ) );
		return object;
	}

}
