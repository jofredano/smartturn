package co.org.smartturn.data.structure;

import java.io.Serializable;

/**
 * Representa a un objeto general donde contiene datos comunes
 * como datos del creador, estado y modificado.
 * 
 * @author joseanor
 *
 */
public interface Record extends Struct {

	/**
	 * Devuelve la fecha de creacion del usuario.
	 * @return	created
	 */
	public Serializable getCreated();

	/**
	 * Asigna la fecha de creacion del usuario.
	 * @param 	created		Fecha de creacion
	 */
	public void setCreated(Serializable created);
	

	/**
	 * Devuelve la fecha de modificacion del usuario.
	 * @return	modified
	 */
	public Serializable getModified();

	/**
	 * Asigna la fecha de modificacion del usuario.
	 * @param 	modified		Fecha de creacion
	 */
	public void setModified(Serializable modified);

	/**
	 * Devuelve el estado actual del usuario.
	 * @return	state
	 */
	public Serializable getState();
	
	/**
	 * Asigna un estado al usuario.
	 * @param 	state			Estado del usuario
	 */
	public void setState(Serializable state);

	/**
	 * Devuelve el creador de este usuario
	 * @return	creater
	 */
	public Serializable getCreater();
	
	/**
	 * Asigna el creador de este usuario.
	 * @param 	creater
	 */
	public void setCreater(Serializable creater);
	
	/**
	 * Devuelve el modificador de este usuario
	 * @return	modifier
	 */
	public Serializable getModifier();
	
	/**
	 * Asigna el modificador de este usuario.
	 * @param 	modifier
	 */
	public void setModifier(Serializable modifier);
	
}
