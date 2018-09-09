package co.org.smartturn.persistent.dao.security;

import java.io.Serializable;

import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.data.model.security.Credential;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.definitions.DataRepository;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.persistent.vo.security.VOAccess;

/**
 * Interfaz que controla la persistencia del acceso.
 * 
 * @author joseanor
 *
 */
public interface AccessDAO extends DataRepository<VOAccess, Long> {

	/**
	 * Metodo que almacena la informacion
	 * @param 	item		Informacion del acceso
	 * @return	VOAccess
	 * @throws 	PersistentException
	 */
	public VOAccess create(VOAccess item) throws PersistentException;
	
	/**
	 * Metodo que actualiza la informacion
	 * @param 	item		Informacion del acceso
	 * @return	Response<Integer>
	 * @throws 	PersistentException
	 */
	public boolean update(VOAccess item) throws PersistentException;

	/**
	 * Permite consultar la informacion de la entidad
	 * @param 	filter	Informacion de los filtros
	 * @param 	paging	Paginacion de los resultados
	 * @return	Response<VOAccess>
	 * @throws 	PersistentException
	 */
	public Result<VOAccess> filter(MapEntity filter, Pageable paging) throws PersistentException;

	/**
	 * Permite consultar la informacion de la entidad
	 * @param 	filter	Informacion de los filtros
	 * @return	Response<VOAccess>
	 * @throws 	PersistentException
	 */
	public Result<VOAccess> filter(MapEntity filter) throws PersistentException;

	/**
	 * Realiza acceso al usuario en el sistema.
	 * @param 	credential		Informacion del usuario
	 * @return	java.util.Map<String, Serializable>
	 * @throws 	PersistentException
	 */
	public java.util.Map<String, Serializable> checkUser(Credential credential) throws PersistentException;

	/**
	 * Realiza validacion con el acceso para indicar si esta vigene o no
	 * @param 	access			Informacion del acceso
	 * @return	boolean
	 * @throws PersistentException
	 */
	public boolean validate(VOAccess access) throws PersistentException;

}
