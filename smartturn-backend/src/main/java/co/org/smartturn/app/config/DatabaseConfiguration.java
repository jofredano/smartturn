package co.org.smartturn.app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuracion de base de datos 
 * 
 * @author joseanor
 *
 */
@Configuration
@EnableTransactionManagement
@EntityScan( "co.org.smartturn.domain.vo" )
@ComponentScan( "co.org.smartturn.persistent.dao" )
@EnableJpaRepositories( "co.org.smartturn.persistent.jpa" )
public class DatabaseConfiguration {
	
}
