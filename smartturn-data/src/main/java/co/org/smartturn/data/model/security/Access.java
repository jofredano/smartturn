package co.org.smartturn.data.model.security;

import java.io.Serializable;

/**
 * Define el acceso de un usuario.
 * 
 * @author joseanor
 *
 */
public interface Access<D extends Serializable> extends Credential {

	/**
	 * Permite asignar codigo de acceso
	 * @param 	token
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

}
