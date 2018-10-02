package co.org.smartturn.persistent.jpa.nojpa;

import co.org.smartturn.definitions.database.data.DataRepository;
import co.org.smartturn.domain.vo.VOContact;

/**
 * Interfaz que controla la persistencia del acceso.
 * 
 * @author joseanor
 *
 */
public interface ContactDAO extends DataRepository<VOContact, Long> {

}
