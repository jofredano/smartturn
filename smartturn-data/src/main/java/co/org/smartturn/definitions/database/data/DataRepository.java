package co.org.smartturn.definitions.database.data;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Interfaz que define de manera general
 * un objeto de persistencia dentro de la aplicacion.
 * 
 * @author joseanor
 *
 */
public interface DataRepository<E extends java.io.Serializable, K extends java.io.Serializable> {

	/**
	 * Asigna plantilla jdbc al DAO
	 * 
	 * @param template
	 */
	public void setTemplate(JdbcTemplate template);

}

