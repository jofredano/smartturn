package co.org.smartturn.persistent.jpa;

import co.org.smartturn.definitions.database.jpa.EntityRepository;
import co.org.smartturn.domain.vo.VOContact;

/**
 * Interfaz que define las operaciones a los usuarios.
 * 
 * @author joseanor
 *
 */
public interface JpaContactRepository extends EntityRepository<VOContact, Long> {

}
