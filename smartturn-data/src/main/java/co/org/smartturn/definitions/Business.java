package co.org.smartturn.definitions;

/**
 * Interfaz que define de manera general
 * un objeto de negocio dentro de la aplicacion.
 * 
 * @author joseanor
 *
 */
public interface Business {
	
	/**
	 * Obtiene el objeto de repositorio asociado a este objeto de negocio.
	 * @return	DatabaseRepository
	 */
	public DataRepository<?,?> getRepository();
	
}
