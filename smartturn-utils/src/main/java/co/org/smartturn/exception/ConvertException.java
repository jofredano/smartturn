package co.org.smartturn.exception;

import co.org.smartturn.exception.data.Descriptor;

/**
 * Clase que representa una excepcion de conversion.
 * 
 * @author joseanor
 *
 */
public final class ConvertException extends SystemException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepcion
	 * @param 	code			Codigo de la excepcion
	 * @param 	description		Descripcion de la excepcion
	 */
	public ConvertException(String code, String description) {
		super("PER"+code, description);
	}
	
	/**
	 * Constructor de la excepcion
	 * @param 	code			Codigo de la excepcion
	 * @param 	description		Descripcion de la excepcion
	 * @param 	cause			Causa del error
	 */
	public ConvertException(String code, String description, Throwable cause) {
		super("PER"+code, description, cause);
	}
	
	/**
	 * Constructor de la excepcion
	 * @param 	code			Codigo de la excepcion SQL
	 * @param 	description		Descripcion de la excepcion
	 * @param 	cause			Causa del error
	 */
	public ConvertException(int code, String description, Throwable cause) {
		this(String.valueOf(code), description, cause);
	}
	
	@Override
	public Descriptor getDefinition() {
		return new Descriptor(getCode(), getMessage());
	}

}
