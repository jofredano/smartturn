package co.org.smartturn.data.structure;

/**
 * Interfaz que define de manera general un campo.
 * 
 * @author joseanor
 *
 */
public interface Field extends java.io.Serializable {

	/**
	 * Obtiene el nombre del campo.
	 * @return	name
	 */
	public String getName();
	
	/**
	 * Obtiene si el campo es clave principal dentro del objeto.
	 * @return	key
	 */
	public boolean isKey();
	
	/**
	 * Obtiene la descripcion del campo.
	 * @return	description
	 */
	public String getDescription();
	
}
