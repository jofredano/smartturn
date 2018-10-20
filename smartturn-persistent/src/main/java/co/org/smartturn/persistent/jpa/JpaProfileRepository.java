package co.org.smartturn.persistent.jpa;

import co.org.smartturn.definitions.database.jpa.EntityRepository;
import co.org.smartturn.domain.vo.VOProfile;

/**
 * Interfaz que define las operaciones a los perfiles.
 * 
 * @author joseanor
 *
 */
public interface JpaProfileRepository extends EntityRepository<VOProfile, Long> {
}
