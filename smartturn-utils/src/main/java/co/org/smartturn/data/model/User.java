package co.org.smartturn.data.model;

import java.io.Serializable;
import java.util.List;

import co.org.smartturn.data.model.security.Credential;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.structure.Record;

/**
 * Estructura general de un usuario.
 * Se define asi, porque depende del contexto en el que se hable
 * Objeto de persistencia o objeto de negocio, se puede definir de la misma manera
 * pero cambia de acuerdo a como vaya orientado.
 * 
 * @author joseanor
 *
 */
public interface User<P extends Serializable> extends Record, Credential, MapEntity {

	/**
	 * Devuelve el codigo del usuario
	 * @return	long
	 */
	public long getCode();
	
	/**
	 * Asigna el codigo del usuario
	 * @param 	code	Codigo
	 */
	public void setCode(long code);
	
	/**
	 * Obtiene la informacion base del usuario
	 * (puede ser toda la informacion de contacto) 
	 * 
	 * @return	contact
	 */
	public Serializable getContact();
	
	/**
	 * Asigna la informacion de contacto del usuario
	 * @param 	contact		Informacion de contacto
	 */
	public void setContact(Serializable contact);

	/**
	 * Devuelve los perfiles asociados al usuario
	 * @return 	profiles
	 */
	public List<P> getProfiles();
	
	/**
	 * Asigna perfiles a este usuario
	 * @param 	profiles	Perfiles del usuario
	 */
	public void setProfiles(List<P> profiles);

}
