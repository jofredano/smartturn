package co.org.smartturn.data.transfer.filter;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.structure.DTODocument;
import co.org.smartturn.data.transfer.structure.ObjectMap;
import co.org.smartturn.exception.transfer.MapperException;

/**
 * Esta clase controla el objeto que sirve como filtro para hacer busquedas
 * de usuario.
 * 
 * @author joseanor
 *
 */
@XmlRootElement
public final class UserFilter extends ObjectMap implements MapEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Primer nombre.
	 */
	@XmlElement(name = "firstname")
	private String firstname;

	/**
	 * Segundo nombre.
	 */
	@XmlElement(name = "secondname")
	private String secondname;

	/**
	 * Primer apellido.
	 */
	@XmlElement(name = "firstLastname")
	private String firstLastname;

	/**
	 * Segundo apellido.
	 */
	@XmlElement(name = "secondLastname")
	private String secondLastname;

	/**
	 * Nombre de usuario
	 */
	@XmlElement(name = "username")
	private String username;

	/**
	 * Identificacion del contacto.
	 */
	@XmlElement(name = "identification")
	private DTODocument identification;
	
	/**
	 * Permite definir un rango de fechas de nacimiento
	 */
	@XmlElement(name = "birthday")
	private RangeDate birthday;
	
	/**
	 * Permite definir un rango de fechas de creacion del usuario
	 */
	@XmlElement(name = "created")
	private RangeDate created;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getFirstLastname() {
		return firstLastname;
	}

	public void setFirstLastname(String firstLastname) {
		this.firstLastname = firstLastname;
	}

	public String getSecondLastname() {
		return secondLastname;
	}

	public void setSecondLastname(String secondLastname) {
		this.secondLastname = secondLastname;
	}

	public DTODocument getIdentification() {
		return identification;
	}

	public void setIdentification(DTODocument identification) {
		this.identification = identification;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public RangeDate getBirthday() {
		return birthday;
	}

	public void setBirthday(RangeDate birthday) {
		this.birthday = birthday;
	}

	public RangeDate getCreated() {
		return created;
	}

	public void setCreated(RangeDate created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		return "UserFilter [firstname=" + firstname + ", secondname=" + secondname + ", firstLastname=" + firstLastname
				+ ", secondLastname=" + secondLastname + ", identification=" + identification + ", username=" + username
				+ ", birthday=" + birthday + ", created=" + created + "]";
	}
	
	@Override
	public Serializable get(Field field) {
		ColumnFilter filter = (ColumnFilter)field;
		switch(filter) {
			case USER_NAME 		  		: return getUsername();
			case USER_BIRTHDAY 	  		: return getBirthday();
			case USER_FIRSTNAME   		: return getFirstname();
			case USER_SECONDNAME  		: return getSecondname();
			case USER_FIRSTLASTNAME 	: return getFirstLastname();
			case USER_SECONDLASTNAME	: return getSecondLastname();
			case USER_IDENTIFICATION	: return getIdentification();
			case USER_CREATED 			: return getCreated();
			default 					: return null;
		}
	}

	@Override
	public void put(Field field, Serializable value) {
		ColumnFilter filter = (ColumnFilter)field;
		switch(filter) {
			case USER_NAME 		  		: setUsername( (String)value ); break;
			case USER_BIRTHDAY 	  		: setBirthday( (RangeDate)value ); break;
			case USER_FIRSTNAME   		: setFirstname( (String)value ); break;
			case USER_SECONDNAME  		: setSecondname( (String)value ); break;
			case USER_FIRSTLASTNAME 	: setFirstLastname( (String)value ); break;
			case USER_SECONDLASTNAME	: setSecondLastname( (String)value ); break;
			case USER_IDENTIFICATION	: setIdentification( (DTODocument)value ); break;
			case USER_CREATED 			: setCreated( (RangeDate)value ); break;
			default 					: break;
		}
	}

	@Override
	public MapEntity map(Class<?> name, MapEntity source) throws MapperException {
		return null;
	}

	/**
	 * Enumerador de los campos.
	 * 
	 * @author joseanor
	 *
	 */
	public enum ColumnFilter implements Field {
		USER_NAME("alias"),
		USER_BIRTHDAY("nacimiento"),
		USER_FIRSTNAME("primerNombre"),
		USER_SECONDNAME("segundoNombre"),
		USER_FIRSTLASTNAME("primerApellido"),
		USER_SECONDLASTNAME("segundoApellido"),
		USER_CREATED("creado"),
		USER_IDENTIFICATION("identificacion");
		
		/**
		 * Nombre del campo
		 */
		private final String name;
		
		private ColumnFilter(String name) {
			this.name = name;
		}
		
		@Override
		public String getName() {
			return name;
		}

		@Override
		public boolean isKey() {
			return false;
		}

		@Override
		public String getDescription() {
			return null;
		}
	}

}
