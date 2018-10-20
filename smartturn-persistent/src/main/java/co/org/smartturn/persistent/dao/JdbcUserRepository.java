package co.org.smartturn.persistent.dao;

import co.org.smartturn.definitions.database.data.DataRepository;
import co.org.smartturn.domain.vo.VOUser;

/**
 * Interfaz que define las operaciones a los usuarios.
 * 
 * @author joseanor
 *
 */
public interface JdbcUserRepository extends DataRepository<VOUser, Long>{

}
