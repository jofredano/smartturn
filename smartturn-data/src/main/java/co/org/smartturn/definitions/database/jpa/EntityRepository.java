package co.org.smartturn.definitions.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * Interfaz que define de manera general
 * un objeto de persistencia dentro de la aplicacion por JPA.
 * 
 * @author joseanor
 *
 */
public interface EntityRepository<E extends java.io.Serializable, K extends java.io.Serializable> 
    extends JpaRepository<E, K>, JpaSpecificationExecutor<E> {

}
