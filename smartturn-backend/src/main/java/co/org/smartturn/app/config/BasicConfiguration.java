package co.org.smartturn.app.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Clase que maneja la configuracion basica del proyecto
 * 
 * @author joseanor
 *
 */
@Configuration
@ComponentScan(
   basePackages = { 
	 "co.org.smartturn.app.services",
	 "co.org.smartturn.business",
	 "co.org.smartturn.persistent.dao"
})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class BasicConfiguration {

}
