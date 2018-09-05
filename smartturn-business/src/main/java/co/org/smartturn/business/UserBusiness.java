package co.org.smartturn.business;

import co.org.smartturn.data.model.User;
import co.org.smartturn.data.model.response.Response;
import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.data.model.security.Access;
import co.org.smartturn.data.model.security.Credential;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.DTOUser;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.data.transfer.security.DTOAccess;
import co.org.smartturn.definitions.Business;
import co.org.smartturn.exception.SystemException;

/**
 * Interfaz que define operaciones relacionadas con usuarios
 * a nivel de negocio.
 * 
 * @author joseanor
 *
 */
public interface UserBusiness extends Business {

	/**
	 * Permite realizar consulta de los usuarios.
	 * @param 	filter			Filtro de busqueda
	 * @param 	paging			Paginacion de los resultados
	 * @return	Result<DTOUser>
	 * @throws 	SystemException
	 */
	public Result<DTOUser> filter(
		MapEntity 	filter, 
		Pageable 	paging) throws SystemException;
	
	/**
	 * Permite realizar consulta de los usuarios.
	 * @param 	filter			Filtro de busqueda
	 * @return	Result<DTOUser>
	 * @throws 	SystemException
	 */
	public Result<DTOUser> filter(MapEntity filter) throws SystemException;
	
	/**
	 * Permite actualizar/guardar la informacion de un usuario
	 * @param 	user			Informacion del usuario
	 * @return	boolean
	 * @throws 	SystemException
	 */
	public boolean update(User<?> user) throws SystemException;

	/**
	 * Permite realizar acceso a un usuario 
	 * @param 	credential		Credenciales del usuario
	 * @return	Response<DTOAccess>
	 * @throws 	SystemException
	 */
	public Response<DTOAccess> access(Credential credential) throws SystemException;
	
	/**
	 * Permite cerrar el acceso del usuario
	 * @param 	credential		Acceso entregado al usuario
	 * @return	ResponseData
	 * @throws 	SystemException
	 */
	public Response<Integer> logout(Access<java.util.Date, DTOUser> credential) throws SystemException;
	
	/**
	 * Permite validar si el acceso esta vigente
	 * @param 	credential		Acceso entregado al usuario
	 * @return	ResponseData
	 * @throws 	SystemException
	 */
	public Response<Integer> validate(Access<java.util.Date, DTOUser> credential) throws SystemException;

}
