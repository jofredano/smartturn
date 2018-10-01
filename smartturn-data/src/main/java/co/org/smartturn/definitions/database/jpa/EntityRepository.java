package co.org.smartturn.definitions.database.jpa;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;


/**
 * Interfaz que define de manera general
 * un objeto de persistencia dentro de la aplicacion por JPA.
 * 
 * @author joseanor
 *
 */
public interface EntityRepository<E extends java.io.Serializable, K extends java.io.Serializable> 
    extends CrudRepository<E, K>, JpaSpecificationExecutor<E> {

}
