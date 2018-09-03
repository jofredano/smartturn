package co.org.smartturn.exception;

import co.org.smartturn.exception.data.Descriptor;

/**
 * Excepcion que se genera cuando se presenta un error en la base de datos.
 * 
 * @author joseanor
 *
 */
public class PersistentException extends SystemException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepcion
	 * @param 	code			Codigo de la excepcion
	 * @param 	description		Descripcion de la excepcion
	 */
	public PersistentException(String code, String description) {
		super("PER"+code, description);
	}
	
	/**
	 * Constructor de la excepcion
	 * @param 	code			Codigo de la excepcion
	 * @param 	description		Descripcion de la excepcion
	 * @param 	cause			Causa del error
	 */
	public PersistentException(String code, String description, Throwable cause) {
		super("PER"+code, description, cause);
	}
	
	/**
	 * Constructor de la excepcion
	 * @param 	code			Codigo de la excepcion SQL
	 * @param 	description		Descripcion de la excepcion
	 * @param 	cause			Causa del error
	 */
	public PersistentException(int code, String description, Throwable cause) {
		this(String.valueOf(code), description, cause);
	}
	
	@Override
	public Descriptor getDefinition() {
		return new Descriptor(getCode(), getMessage());
	}
}
