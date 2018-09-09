package co.org.smartturn.data.model.security;

import co.org.smartturn.data.structure.Struct;

/**
 * Estructura general de un usuario (acceso).
 * Se define asi, porque depende del contexto en el que se hable
 * Objeto de persistencia o objeto de negocio, se puede definir de la misma manera
 * pero cambia de acuerdo a como vaya orientado.
 * 
 * @author joseanor
 *
 */
public interface Credential extends Struct {

	/**
	 * Devuelve el nombre de usuario del usuario (alias)
	 * @return	username
	 */
	public String getUsername();
	
	/**
	 * Asigna el nombre de usuario (alias)
	 * @param 	username	Nombre de usuario
	 */
	public void setUsername(String username);
	
	/**
	 * Devuelve la clave del usuario.
	 * @return	password
	 */
	public String getPassword();
	
	/**
	 * Asigna la clave del usuario.
	 * @param 	password	Clave del usuario.
	 */
	public void setPassword(String password);
}
