package co.org.smartturn.exception.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representa un error dentro de la validacion (asociada a un campo)
 * 
 * @author henry
 *
 */
@XmlRootElement
public class ErrorField implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Campo asociado al error
	 */
	private final String field;
	
	/**
	 * Descripcion del error presentado
	 */
	private final String description;
	
	/**
	 * Constructor del error
	 * @param 	field			Campo asociado al error
	 * @param 	description		Descripcion del error presentado
	 */
	public ErrorField(String field, String description) {
		this.field = field;
		this.description = description;
	}

	public String getField() {
		return field;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return field + ": " + description;
	}

}
