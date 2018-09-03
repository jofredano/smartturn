package co.org.smartturn.data.transfer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import co.org.smartturn.data.model.Motorist;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.adapter.DateAdapter;
import co.org.smartturn.data.transfer.fields.ColumnFields;
import co.org.smartturn.data.transfer.structure.ObjectMap;
import co.org.smartturn.exception.transfer.MapperException;
import co.org.smartturn.utils.Utilities;

/**
 * Objeto que representa a un conductor (motorista).
 * 
 * @author joseanor
 *
 */
public final class DTOMotorist extends ObjectMap implements Motorist, MapEntity {

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
	private Serializable state;

	/**
	 * Usuario que creo el cliente.
	 */
	private Serializable creater;

	/**
	 * Usuario que realizo la ultima modificacion.
	 */
	private Serializable modifier;

	/**
	 * Codigo unico del cliente.
	 */
	private long code;

	/**
	 * Informacion del contacto.
	 */
	private Serializable contact;

	/**
	 * Informacion de la transportadora.
	 */
	private Serializable transport;

	/**
	 * Informacion del cliente.
	 */
	private Serializable client;


	@Override
	public long getCode() {
		return code;
	}

	@Override
	public void setCode(long code) {
		this.code = code;
	}

	@Override
	public Serializable getCreated() {
		return created;
	}

	@Override
	public void setCreated(Serializable created) {
		this.created = (Date) created;
	}

	@Override
	public Serializable getModified() {
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
		this.state = state;
	}

	@Override
	public Serializable getCreater() {
		return creater;
	}

	@Override
	public void setCreater(Serializable creater) {
		this.creater = creater;
	}

	@Override
	public Serializable getModifier() {
		return modifier;
	}

	@Override
	public void setModifier(Serializable modifier) {
		this.modifier = modifier;
	}
	
	@Override
	public Serializable getClient() {
		return client;
	}

	@Override
	public void setClient(Serializable client) {
		this.client = client;
	}

	@Override
	public Serializable getTransport() {
		return transport;
	}

	@Override
	public void setTransport(Serializable transport) {
		this.transport = transport;
	}

	@Override
	public Serializable getContact() {
		return contact;
	}
	
	@Override
	public void setContact(Serializable contact) {
		this.contact = contact;
	}
	
	//Para interactuar con la informacion del conductor

	@Override
	public Serializable getType() {
		return Utilities.getValue(contact, ColumnFields.CONTACT_TYPE);
	}

	@Override
	public void setType(Serializable type) {
		Utilities.putValue(contact, ColumnFields.CONTACT_TYPE, type);
	}

	@Override
	public Serializable getIdentification() {
		return Utilities.getValue(contact, ColumnFields.CONTACT_IDENTIFICATION);
	}

	@Override
	public void setIdentification(Serializable identification) {
		Utilities.putValue(contact, ColumnFields.CONTACT_IDENTIFICATION, identification);
	}

	@Override
	public String getFirstname() {
		return (String)Utilities.getValue(contact, ColumnFields.CONTACT_FIRSTNAME);
	}

	@Override
	public void setFirstname(String firstname) {
		Utilities.putValue(contact, ColumnFields.CONTACT_FIRSTNAME, firstname);
	}

	@Override
	public String getSecondname() {
		return (String)Utilities.getValue(contact, ColumnFields.CONTACT_SECONDNAME);
	}

	@Override
	public void setSecondname(String secondname) {
		Utilities.putValue(contact, ColumnFields.CONTACT_SECONDNAME, secondname);
	}

	@Override
	public String getFirstLastname() {
		return (String)Utilities.getValue(contact, ColumnFields.CONTACT_FIRSTLASTNAME);
	}

	@Override
	public void setFirstLastname(String firstLastname) {
		Utilities.putValue(contact, ColumnFields.CONTACT_FIRSTLASTNAME, firstLastname);
	}

	@Override
	public String getSecondLastname() {
		return (String)Utilities.getValue(contact, ColumnFields.CONTACT_SECONDLASTNAME);
	}

	@Override
	public void setSecondLastname(String secondLastname) {
		Utilities.putValue(contact, ColumnFields.CONTACT_SECONDLASTNAME, secondLastname);
	}

	@Override
	public Serializable getBirth() {
		return Utilities.getValue(contact, ColumnFields.CONTACT_BIRTHDAY);
	}

	@Override
	public void setBirth(Serializable birth) {
		Utilities.putValue(contact, ColumnFields.CONTACT_BIRTHDAY, birth);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Serializable> getReferences() {
		return (List<Serializable>)Utilities.getValue(contact, ColumnFields.CONTACT_REFERENCES);
	}

	@Override
	public void setReferences(List<Serializable> references) {
		Utilities.putValue(contact, ColumnFields.CONTACT_REFERENCES, (ArrayList<Serializable>)references);
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
		return (this.hashCode() == ((DTOProfile)object).hashCode());
	}

	@Override
	public Serializable get(Field field) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case MOTORIST_CODE 		:  return getCode( );  
			case MOTORIST_CREATED 	:  return getCreated( );  
			case MOTORIST_CREATER 	:  return getCreater( );  
			case MOTORIST_MODIFIED 	:  return getModified( );  
			case MOTORIST_MODIFIER 	:  return getModifier( );  
			case MOTORIST_STATE 	:  return getState( ); 
			case MOTORIST_CONTACT	:  return getContact( );
			case MOTORIST_TRANSPORT :  return getTransport( );
			case MOTORIST_CLIENT    :  return getClient( );
			default					:  return null;	
		}
	}

	@Override
	public void put(Field field, Serializable value) {
		ColumnFields column = (ColumnFields)field;	
		switch(column) {
			case MOTORIST_CODE 		 :  setCode( (long)value ); break; 
			case MOTORIST_CREATED 	 :  setCreated( value ); break; 
			case MOTORIST_CREATER 	 :  setCreater( value ); break; 
			case MOTORIST_MODIFIED 	 :  setModified( value ); break; 
			case MOTORIST_MODIFIER 	 :  setModifier( value ); break; 
			case MOTORIST_STATE 	 :  setState( value ); break;
			case MOTORIST_CONTACT	 :  setContact( value ); break;
			case MOTORIST_TRANSPORT  :  setTransport( value ); break;
			case MOTORIST_CLIENT 	 :  setClient( value ); break;
			default					 :  break;
		}
	}

	@Override
	public MapEntity map(Class<?> name, MapEntity source) throws MapperException {
		return null;
	}

}
