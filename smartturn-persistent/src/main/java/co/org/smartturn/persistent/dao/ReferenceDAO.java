package co.org.smartturn.persistent.dao;

import co.org.smartturn.data.model.Reference;
import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.definitions.DataRepository;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.persistent.vo.VOReference;

/**
 * Interfaz que define las operaciones a los usuarios.
 * 
 * @author joseanor
 *
 */
public interface ReferenceDAO extends DataRepository<VOReference, Long> {

	/**
	 * Permite realizar consulta de las referencias.
	 * @param 	filter			Filtro de busqueda
	 * @param 	paging			Paginacion de los resultados
	 * @return	Result<VOReference>
	 * @throws 	PersistentException
	 */
	public Result<VOReference> filter(MapEntity filter, Pageable paging) throws PersistentException;

	/**
	 * Permite realizar consulta de las referencias.
	 * @param 	filter			Filtro de busqueda
	 * @return	Result<VOReference>
	 * @throws 	PersistentException
	 */
	public Result<VOReference> filter(MapEntity filter) throws PersistentException;
	
	/**
	 * Metodo que almacena la informacion
	 * @param 	item		Informacion de referencia
	 * @return	boolean
	 * @throws 	PersistentException
	 */
	public boolean update(Reference item) throws PersistentException;
}
