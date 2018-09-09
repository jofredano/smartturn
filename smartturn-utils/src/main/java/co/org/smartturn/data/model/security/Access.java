package co.org.smartturn.data.model.security;

import java.io.Serializable;

import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.structure.Struct;

/**
 * Define el acceso de un usuario.
 * 
 * @author joseanor
 *
 */
public interface Access<D extends Serializable, U extends Serializable> extends Struct, MapEntity {

	/**
	 * Asigna la informacion del usuario
	 * @param 	user	Informacion del usuario
	 */
	public void setUser(U user);
	
	/**
	 * Obtiene la informacion del usuario
	 * @return	user
	 */
	public U getUser();
	
	/**
	 * Permite asignar codigo de acceso
	 * @param 	token	Token del usuario
	 */
	public void setToken(String token);
	
	/**
	 * Obtiene el codigo de acceso entregado
	 * @return	token
	 */
	public String getToken();
	
	/**
	 * Obtiene la fecha de inicio del acceso
	 * @return 	begin
	 */
	public D getBegin();

	/**
	 * Asigna la fecha de inicio del acceso
	 * @param 	begin	Fecha del acceso
	 */
	public void setBegin(D begin);

	/**
	 * Obtiene la fecha fin del acceso
	 * @return	end
	 */
	public D getEnd();

	/**
	 * Asigna la fecha fin del acceso
	 * @param 	end		Fecha del acceso
	 */
	public void setEnd(D end);
	
	/**
	 * Obtiene la duracion de la sesion
	 * @return	duration
	 */
	public Long getDuration();

	/**
	 * Asigna la duracion del acceso
	 * @param 	duration	Informacion de la duracion
	 */
	public void setDuration(Long duration);

	/**
	 * Obtiene el codigo del acceso
	 * @return	code
	 */
	public Long getCode();

	/**
	 * Asigna el codigo del acceso
	 * @param 	code	Codigo del acceso
	 */
	public void setCode(Long code);
	
	public default Field[] getFields() {
		return null;
	}

}
