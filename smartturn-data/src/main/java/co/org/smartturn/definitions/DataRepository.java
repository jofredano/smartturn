package co.org.smartturn.definitions;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;

import co.org.smartturn.definitions.database.section.Transaction;
import co.org.smartturn.definitions.database.sql.InstructionType;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.utils.callback.Callback;

/**
 * Interfaz que define de manera general
 * un objeto de persistencia dentro de la aplicacion.
 * 
 * @author joseanor
 *
 */
public interface DataRepository<E extends java.io.Serializable, K extends java.io.Serializable> {
	
	/**
	 * Obtiene la instancia de conexion a la base de datos.
	 * @return Connection
	 */
	public Connection getConnection();
	
	/**
	 * Obtiene la sesion de persistencia
	 * 
	 * @return 	Session
	 */
    public Session getSession();

    /**
     * Cierra la sesion de persistencia
     */
    public void closeSession();    
	
    /**
     * Ejeuta la transaccion de la persistencia
     * @param 	entity			Entidad relacionada con la transaccion
     * @param 	transaction		Tipo de transaccion a ejecutar
     * @return	T
     * @throws  PersistentException 
     * @throws 	DataException
     */
    public E execute(E entity, Transaction transaction) throws  PersistentException;
    
    /**
     * Ejeuta la transaccion de la persistencia
     * @param 	entity			Entidad relacionada con la transaccion
     * @param 	transaction		Tipo de transaccion a ejecutar
     * @param 	callback		Instancia para llamado posterior de realizar operacion
     * @return  T
     * @throws  PersistentException 
     * @throws 	DataException 
     */
    public E execute(E entity, Transaction transaction, Callback<E, Boolean> callback) throws  PersistentException;

	/**
	 * Ejecuta de manera masiva la transaccion de una cantidad de entidades
	 * @param 	entities		Listado de entidades
	 * @param 	transaction		Tipo de transaccion
	 * @return	List<T>
	 * @throws  PersistentException 
	 */
	public List<E> execute(List<E> entities, Transaction transaction) throws  PersistentException;

	/**
	 * Ejecuta de manera masiva la transaccion de una cantidad de entidades
	 * @param 	entities		Listado de entidades
	 * @param 	transaction		Tipo de transaccion
	 * @param 	callback		Instancia para llamado posterior de realizar operacion
	 * @return	List<T>
	 * @throws  PersistentException 
	 */
	public List<E> execute(
		List<E> entities, 
		Transaction transaction, 
		Callback<List<E>, Boolean> callback ) throws  PersistentException;
	
    /**
     * Ejecuta la transaccion para procesos UPDATE
     * @param 	type			Tipo de instruccion SQL 
     * @param 	sql				Instruccion SQL
     * @param 	transaction		Tipo de transaccion.
     * @return	K
     * @throws  PersistentException 
     */
	public Integer executeUpdate(
		InstructionType  type, 
		String 			 sql, 
		Transaction 	 transaction) throws  PersistentException;
	
	/**
	 * Permite obtener un unico resultado de una consulta
	 * @param 	entity 	Objeto entidad
	 * @param 	key		Clave de la entidad
	 * @return	E
	 */
	public E getSingleResult(Class<E> entity, K key);
	
	/**
	 * Permite obtener un unico resultado de una consulta
	 * @param 	sql		Comando SQL a ejecutar
	 * @return	T
	 */
	public <T extends Serializable> T getSingleResult(String sql);

	/**
	 * Permite terminar la instancia
	 */
	public void shutdown();
}

