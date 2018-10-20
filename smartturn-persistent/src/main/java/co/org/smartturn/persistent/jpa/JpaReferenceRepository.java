package co.org.smartturn.persistent.jpa;

import co.org.smartturn.definitions.database.jpa.EntityRepository;
import co.org.smartturn.domain.vo.VOReference;

/**
 * Interfaz que define las operaciones a los usuarios.
 * 
 * @author joseanor
 *
 */
public interface JpaReferenceRepository extends EntityRepository<VOReference, Long> {

}
