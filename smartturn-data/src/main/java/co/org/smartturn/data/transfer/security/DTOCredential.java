package co.org.smartturn.data.transfer.security;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import co.org.smartturn.data.model.security.Credential;
import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.transfer.structure.ObjectMap;

/**
 * Objeto que representa la informacion que un usuario debe suministrar
 * para acceder al sistema.
 * 
 * @author joseanor
 *
 */
@XmlRootElement
public final class DTOCredential extends ObjectMap implements Credential {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Clave del usuario.
	 */
	@XmlElement(name = "password")
	private String password;
	
	/**
	 * Nombre de usuario.
	 */
	@XmlElement(name = "username")
	private String username;

	
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
	public Field[] getFields() {
		return null;
	}

}
