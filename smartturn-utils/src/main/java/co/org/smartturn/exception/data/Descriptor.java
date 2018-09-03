package co.org.smartturn.exception.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Objeto para entregar detalle de la excepcion.
 *   
 * @author henry
 *
 */
@XmlRootElement(name = "definicion")
public class Descriptor implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Codigo de la excepcion
	 */
	private String code;
	
	/**
	 * Descripcion de la excepcion
	 */
	private String description;
	
	/**
	 * Listado de errores presentados
	 */
	private ArrayList<ErrorField> errors;

	/**
	 * Constructor de la clase.
	 * @param 	code			Codigo de la excepcion
	 * @param 	description		Descripcion de la excepcion	
	 * @param 	errors			Listado de errores
	 */
	public Descriptor(String code, String description, List<ErrorField> errors) {
		this.code = code;
		this.description = description;
		this.errors = (ArrayList<ErrorField>) errors;
	}
	
	/**
	 * Constructor de la clase.
	 * @param 	code			Codigo de la excepcion
	 * @param 	description		Descripcion de la excepcion	
	 */
	public Descriptor(String code, String description) {
		this(code, description,  new ArrayList<ErrorField>());
	}
	
	/**
	 * Constructor de la clase.
	 */
	public Descriptor() {
		this(null, null, new ArrayList<ErrorField>());
	}
	
	public String getDescription() {
		return description;
	}

	public String getCode() {
		return code;
	}
	
	@XmlTransient
	public List<ErrorField> getErrors() {
		return errors;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setErrors(List<ErrorField> errors) {
		this.errors = (ArrayList<ErrorField>) errors;
	}

}