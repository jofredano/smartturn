package co.org.smartturn.persistent.jpa;

import co.org.smartturn.definitions.database.jpa.EntityRepository;
import co.org.smartturn.domain.vo.VOAccess;

/**
 * Interfaz que controla la persistencia del acceso.
 * 
 * @author joseanor
 *
 */
public interface AccessRepository extends EntityRepository<VOAccess, Long> {
}
