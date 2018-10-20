package co.org.smartturn.persistent.jpa;

import java.util.List;

import javax.persistence.Tuple;

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
public interface JpaUserRepository extends EntityRepository<VOUser, Long> {

    /**
     * Busca usuarios basado en criterios de consulta
     * @param 	username	Nombre de usuario  
     * @return  List<VOUser>
     */
    public List<VOUser> findByUsername(String username, Sort sort);
    
    /**
     * Busca usuarios basado en criterios de consulta
     * @param 	username 	Nombre de usuario
     * @param   state		Estado del usuario
     * @param   sort 		Instancia de ordemaniento
     * @return	List<VOUser>
     */
    @Query("SELECT p FROM VOUser p WHERE LOWER(p.username) = LOWER(:username) AND p.state = :state")
    public List<VOUser> find(
    	@Param("username") 	String username,
    	@Param("state") 	Long state, 
    	Sort 				sort);
    
    /**
     * Metodo que obtiene informacion del usuario
     * @return	List<Tuple>	
     */
    @Query("SELECT p.username AS username, p.password AS password, p.state AS state, p.code AS code FROM VOUser p WHERE LOWER(p.username) = LOWER(:username)")
    public List<Tuple> findByUsername(@Param("username") String username);

}
