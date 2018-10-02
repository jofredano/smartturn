package co.org.smartturn.persistent.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.org.smartturn.definitions.database.jpa.EntityRepository;
import co.org.smartturn.domain.vo.VOAccess;

/**
 * Interfaz que controla la persistencia del acceso.
 * 
 * @author joseanor
 *
 */
public interface AccessRepository extends EntityRepository<VOAccess, Long> {
	
	/**
	 * Verifica si existe el acceso activo
	 * @param 	credential
	 * @return	String
	 */
	@Query(nativeQuery = true, value= "${AccessRepository.checkAccessByToken}")
	public String checkAccessByToken(
		@Param("token") String token);
	
	/**
	 * Obtiene la informacion de acceso a traves del token
	 * @param 	token		Informacion del token
	 * @return	VOAccess
	 */
	@Query("SELECT p FROM VOAccess p WHERE p.token = :token")
	public VOAccess getOneByToken(
		@Param("token") String token);

}
