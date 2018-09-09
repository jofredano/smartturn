package co.org.smartturn.business;

import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.DTOContact;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.definitions.Business;
import co.org.smartturn.exception.SystemException;

/**
 * Interfaz que define operaciones relacionadas con contactos
 * a nivel de negocio.
 * 
 * @author joseanor
 *
 */
public interface ContactBusiness extends Business {
	
	/**
	 * Permite realizar consulta de los contactos.
	 * @param 	filter			Filtro de busqueda
	 * @param 	paging			Paginacion de los resultados
	 * @return	Result<DTOContact>
	 * @throws 	SystemException
	 */
	public Result<DTOContact> filter(
		MapEntity 	filter, 
		Pageable 	paging) throws SystemException;
	
	/**
	 * Permite realizar consulta de los contactos.
	 * @param 	filter			Filtro de busqueda
	 * @return	Result<DTOContact>
	 * @throws 	SystemException
	 */
	public Result<DTOContact> filter(MapEntity filter) throws SystemException;
	
	/**
	 * Permite actualizar/guardar la informacion de un contacto
	 * @param 	object			Informacion del contacto
	 * @return	boolean
	 * @throws 	SystemException
	 */
	public boolean update(DTOContact object) throws SystemException;

}
