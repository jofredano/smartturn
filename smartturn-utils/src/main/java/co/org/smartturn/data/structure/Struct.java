package co.org.smartturn.data.structure;

/**
 * Define un objeto de manera general dentro del sistema.
 * 
 * @author joseanor
 *
 */
public interface Struct extends java.io.Serializable {
	
	/**
	 * Devuelve el codigo hash del objeto
	 * @return	hashCode	Numero que representa el codigo hash de este objeto.
	 */
	public int hashCode();
	
	/**
	 * Compara con otro objeto
	 * @param 	object
	 * @return	boolean
	 */
	public boolean equals(Object object);
	
	/**
	 * Convierte a string 
	 * @return
	 */
	public String toString();

}
