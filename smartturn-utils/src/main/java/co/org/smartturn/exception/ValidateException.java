package co.org.smartturn.exception;

import java.util.ArrayList;
import java.util.List;

import co.org.smartturn.exception.data.Descriptor;
import co.org.smartturn.exception.data.ErrorField;

/**
 * Clase que permite entregar errores de validacion.
 *  
 * @author henry
 *
 */
public final class ValidateException extends SystemException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Listado de errores presentados
	 */
	private final ArrayList<ErrorField> errors;

	/**
	 * Errores de validacion
	 * @param 	code		Codigo del error
	 * @param 	message		Mensaje del error
	 */
	public ValidateException(String code, String message) {
		this(code, message, new ArrayList<ErrorField>());
	}
	
	/**
	 * Errores de validacion
	 * @param 	code		Codigo del error
	 * @param 	message		Mensaje del error
	 * @param 	cause		Excepcion causante del error
	 */
	public ValidateException(String code, String message, Throwable cause) {
		this(code, message, cause, new ArrayList<ErrorField>());
	}
	
	/**
	 * Errores de validacion
	 * @param 	code		Codigo del error
	 * @param 	message		Mensaje del error
	 * @param 	errors		Listado de errores
	 */
	public ValidateException(String code, String message, List<ErrorField> errors) {
		super(code, message);
		this.errors = (ArrayList<ErrorField>) errors;
	}
	
	/**
	 * Errores de validacion
	 * @param 	code		Codigo del error
	 * @param 	message		Mensaje del error
	 * @param 	cause		Excepcion causante del error
	 * @param 	errors		Listado de errores
	 */
	public ValidateException(String code, String message, Throwable cause, List<ErrorField> errors) {
		super(code, message, cause);
		this.errors = (ArrayList<ErrorField>) errors;
	}
	
	/**
	 * Listado de errores presentados en la validacion.
	 * @return List<Error>
	 */
	public List<ErrorField> getErrors() {
		return errors;
	}
	
	@Override
	public Descriptor getDefinition() {
		return new Descriptor(getCode(), getMessage(), errors);
	}

}
