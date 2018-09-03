package co.org.smartturn.persistent.dao;

import co.org.smartturn.data.model.response.Response;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.definitions.DataRepository;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.persistent.vo.VOUser;

/**
 * Interfaz que define las operaciones a los usuarios.
 * 
 * @author joseanor
 *
 */
public interface UserDAO extends DataRepository<VOUser, Long> {

	/**
	 * Permite realizar consulta de los usuarios.
	 * @param 	filter			Filtro de busqueda
	 * @param 	paging			Paginacion de los resultados
	 * @return	ResponseData
	 * @throws 	PersistentException
	 */
	public Response<VOUser> filter(
		MapEntity 	filter, 
		Pageable 	paging) throws PersistentException;
	
	/**
	 * Permite realizar consulta de los usuarios.
	 * @param 	filter			Filtro de busqueda
	 * @return	ResponseData
	 * @throws 	PersistentException
	 */
	public Response<VOUser> filter(MapEntity filter) throws PersistentException;
	
	/**
	 * Permite actualizar/guardar la informacion de un usuario
	 * @param 	user			Informacion del usuario
	 * @return	boolean
	 * @throws 	PersistentException
	 */
	public boolean update(VOUser user) throws PersistentException;

	/**
	 * Permite realizar acceso a un usuario 
	 * @param 	credential		Credenciales del usuario
	 * @return	boolean
	 * @throws 	PersistentException
	 */
	public boolean checkLogin(VOUser credential) throws PersistentException;

}
