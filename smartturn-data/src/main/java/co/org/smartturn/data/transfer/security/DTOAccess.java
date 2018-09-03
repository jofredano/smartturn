package co.org.smartturn.data.transfer.security;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import co.org.smartturn.data.model.security.Access;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.transfer.adapter.DateAdapter;
import co.org.smartturn.data.transfer.structure.ObjectMap;

/**
 * Representa la informacion de acceso al sistema de un usuario. 
 *
 * @author joseanor
 *
 */
@XmlRootElement
public final class DTOAccess extends ObjectMap implements Access<java.util.Date> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Nombre de usuario usado
	 */
	@XmlElement(name = "username")
	private String username;

	/**
	 * Clave digitada por el usuario.
	 */
	@XmlElement(name = "password")
	private String password;

	/**
	 * Codigo de acceso otorgado por el sistema.
	 */
	@XmlElement(name = "token")
	private String token;
	
	/**
	 * Fecha de inicio del acceso
	 */
	@XmlElement(name = "begin")
	@XmlJavaTypeAdapter( DateAdapter.class )
	private java.util.Date begin;
	
	/**
	 * Fecha de inicio del acceso
	 */
	@XmlElement(name = "end")
	@XmlJavaTypeAdapter( DateAdapter.class )
	private java.util.Date end;

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

	@XmlTransient
	@Override
	public void setPassword(String password) {
		this.password = password;
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
	public java.util.Date getBegin() {
		return begin;
	}

	@Override
	public void setBegin(java.util.Date begin) {
		this.begin = begin;
	}

	@Override
	public java.util.Date getEnd() {
		return end;
	}

	@Override
	public void setEnd(java.util.Date end) {
		this.end = end;
	}

	@Override
	public Field[] getFields() {
		return null;
	}

}
