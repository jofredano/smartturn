package co.org.smartturn.exception;

import java.io.Serializable;

/**
 * Define una excepcion general del sistema.
 * 
 * @author joseanor
 *
 */
public abstract class SystemException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Codigo asociado al error.
	 */
	private final String code;
	
	/**
	 * Constructor para definir la excepcion
	 * @param 	code		Codigo del error
	 * @param 	message		Mensaje asociado al error
	 * @param 	cause		Excepcion de la causa
	 */
	public SystemException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}
	
	/**
	 * Constructor para definir la excepcion
	 * @param 	code		Codigo del error
	 * @param 	message		Mensaje asociado al error
	 */
	public SystemException(String code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * Obtener codigo del error
	 * @return String
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Obtiene la definicion de la excepcion.
	 * 
	 * @return	Definition
	 */
	public abstract Serializable getDefinition();

}
