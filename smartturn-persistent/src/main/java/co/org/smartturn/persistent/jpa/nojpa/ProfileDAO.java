package co.org.smartturn.persistent.jpa.nojpa;

import co.org.smartturn.definitions.database.data.DataRepository;
import co.org.smartturn.domain.vo.VOProfile;

/**
 * Interfaz que define las operaciones a los perfiles.
 * 
 * @author joseanor
 *
 */
public interface ProfileDAO extends DataRepository<VOProfile, Long> {

}
