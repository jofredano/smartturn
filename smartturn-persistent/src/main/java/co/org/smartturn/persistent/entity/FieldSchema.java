package co.org.smartturn.persistent.entity;

import co.org.smartturn.data.structure.Field;

/**
 * Representa un campo del esquema JPA.
 * 
 * @author joseanor
 *
 */
public final class FieldSchema implements Field {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Nombre del campo (JPA)
	 */
	private String name;
	
	/**
	 * Indica si es clave primaria dentro de la entidad.
	 */
	private boolean key;
	
	/**
	 * Descripcion del campo.
	 */
	private String description;

	/**
	 * Constructor de la clase.
	 * @param 	name			Nombre del campo
	 * @param 	description		Descripcion
	 * @param 	key				Si es clave primaria
	 */
	public FieldSchema(String name, String description, boolean key) {
		this.name = name;
		this.description = description;
		this.key = key;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isKey() {
		return key;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
