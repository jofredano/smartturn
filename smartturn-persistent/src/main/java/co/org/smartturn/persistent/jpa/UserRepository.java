package co.org.smartturn.persistent.jpa;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.org.smartturn.definitions.database.jpa.EntityRepository;
import co.org.smartturn.domain.vo.VOUser;

/**
 * Interfaz que define las operaciones a los usuarios.
 * 
 * @author joseanor
 *
 */
public interface UserRepository extends EntityRepository<VOUser, Long> {

    /**
     * Busca usuarios basado en criterios de consulta
     * @param 	username	Nombre de usuario  
     * @return  List<VOUser>
     */
    public List<VOUser> findByUsername(String username, Sort sort);
    
    /**
     * Busca usuarios basado en criterios de consulta
     * @param 	lastName
     * @return
     */
    @Query("SELECT p FROM VOUser p WHERE LOWER(p.username) = LOWER(:username) AND p.state = :state")
    public List<VOUser> find(
    	@Param("username") 	String username,
    	@Param("state") 	Long state, 
    	Sort 				sort);
}
