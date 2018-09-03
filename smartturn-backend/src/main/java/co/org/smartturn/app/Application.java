package co.org.smartturn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase que define la configuracion de la aplicacion web.
 * 
 * @author joseanor
 *
 */
@SpringBootApplication()
@ComponentScan(
   basePackages = { 
	 "co.org.smartturn.app",
	 "co.org.smartturn.business",
	 "co.org.smartturn.services",
	 "co.org.smartturn.persistent.dao"
})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {
	
	/**
	 * Metodo principal
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
