package co.org.smartturn.persistent.dao;

import co.org.smartturn.data.model.Profile;
import co.org.smartturn.data.model.response.Response;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.definitions.DataRepository;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.persistent.vo.VOProfile;

/**
 * Interfaz que define las operaciones a los perfiles.
 * 
 * @author joseanor
 *
 */
public interface ProfileDAO extends DataRepository<Profile<Long>, Long> {

	public Response<VOProfile> filter(
		MapEntity filter, 
		Pageable paging) throws PersistentException;

	public Response<VOProfile> filter(
		MapEntity filter) throws PersistentException;

	/**
	 * Metodo que almacena la informacion
	 * @param 	item		Informacion del perfil
	 * @return	Response<Integer>
	 * @throws 	PersistentException
	 */
	public Response<Integer> update(
		Profile<?> item) throws PersistentException;

}
