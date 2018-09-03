package co.org.smartturn.exception;

import java.io.Serializable;

import co.org.smartturn.exception.data.Descriptor;

/**
 * Excepcion que se presenta en la capa de negocio.
 * 
 * @author joseanor
 *
 */
public class BusinessException extends SystemException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepcion
	 * @param 	code		Codigo del error
	 * @param 	message		Mensaje asociado al error
	 */
	public BusinessException(String code, String message) {
		super(code, message);
	}
	
	/**
	 * Constructor de la excepcion
	 * @param 	code		Codigo del error
	 * @param 	message		Mensaje asociado al error
	 * @param 	cause		Causa del error
	 */
	public BusinessException(String code, String message, Throwable cause) {
		super(code, message, cause);
	}
	
	@Override
	public Serializable getDefinition() {
		return new Descriptor(getCode(), getMessage());
	}
	
}
