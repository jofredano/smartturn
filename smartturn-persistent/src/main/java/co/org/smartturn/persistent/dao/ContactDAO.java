package co.org.smartturn.persistent.dao;

import co.org.smartturn.data.model.response.Response;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.definitions.DataRepository;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.persistent.vo.VOContact;

/**
 * Interfaz que define las operaciones a los usuarios.
 * 
 * @author joseanor
 *
 */
public interface ContactDAO extends DataRepository<VOContact, Long> {

	/**
	 * Permite realizar consulta de los contactos.
	 * @param 	filter			Filtro de busqueda
	 * @param 	paging			Paginacion de los resultados
	 * @return	Response<VOContact>
	 * @throws 	PersistentException
	 */
	public Response<VOContact> filter(
		MapEntity 	filter, 
		Pageable 	paging) throws PersistentException;

	/**
	 * Permite realizar consulta de los contactos.
	 * @param 	filter			Filtro de busqueda
	 * @return	Response<VOContact>
	 * @throws 	PersistentException
	 */
	public Response<VOContact> filter(MapEntity filter) throws PersistentException;

	/**
	 * Metodo que almacena la informacion
	 * @param 	item		Informacion del contacto
	 * @return	Response<Integer>
	 * @throws 	PersistentException
	 */
	public Response<Integer> update(VOContact item) throws PersistentException;

}
