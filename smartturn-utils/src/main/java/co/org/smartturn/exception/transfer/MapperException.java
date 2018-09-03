package co.org.smartturn.exception.transfer;

import co.org.smartturn.exception.BusinessException;
import co.org.smartturn.exception.data.Descriptor;

/**
 * Excepcion relacionada con el mapeo de informacion.
 * 
 * @author joseanor
 *
 */
public final class MapperException extends BusinessException {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepcion
	 * @param 	code			Codigo de la excepcion
	 * @param 	description		Descripcion de la excepcion
	 */
	public MapperException(String code, String description) {
		super("MAP-"+code, description);
	}
	
	/**
	 * Constructor de la excepcion
	 * @param 	code			Codigo de la excepcion
	 * @param 	description		Descripcion de la excepcion
	 * @param 	cause			Causa del error
	 */
	public MapperException(String code, String description, Throwable cause) {
		super("MAP-"+code, description, cause);
	}
	
	/**
	 * Constructor de la excepcion
	 * @param 	code			Codigo de la excepcion SQL
	 * @param 	description		Descripcion de la excepcion
	 * @param 	cause			Causa del error
	 */
	public MapperException(int code, String description, Throwable cause) {
		this(String.valueOf(code), description, cause);
	}
	
	@Override
	public Descriptor getDefinition() {
		return new Descriptor(getCode(), getMessage());
	}
}
