package co.org.smartturn.persistent.jpa.nojpa.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * Implementacion de la persistencia a perfiles.
 * 
 * @author joseanor
 *
 */
@Transactional
@Repository(value = "profileRepository")
public class ProfileRepositoryImpl {

}
