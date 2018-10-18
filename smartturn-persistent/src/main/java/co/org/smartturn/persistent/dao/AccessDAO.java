package co.org.smartturn.persistent.dao;

import java.io.Serializable;
import java.util.Map;

import co.org.smartturn.data.model.security.Credential;
import co.org.smartturn.definitions.database.data.DataRepository;
import co.org.smartturn.domain.vo.VOAccess;
import co.org.smartturn.exception.PersistentException;

/**
 * Repositorio alternativo para acceso
 * 
 * @author joseanor
 *
 */
public interface AccessDAO extends DataRepository<VOAccess, Long> {

	/**
	 * Validar el acceso de un usuario
	 * @param 	credential		Informacion de las credenciales
	 * @return	Map<String, Serializable>
	 * @throws PersistentException
	 */
	public Map<String, Serializable> checkUser(Credential credential) throws PersistentException;
	
}
