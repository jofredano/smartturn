package co.org.smartturn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import co.org.smartturn.app.config.BasicConfiguration;
import co.org.smartturn.app.config.BusinessConfiguration;
import co.org.smartturn.app.config.SecurityConfiguration;

/**
 * Clase que define la configuracion de la aplicacion web.
 * 
 * @author joseanor
 *
 */
@SpringBootApplication()
@Import(value = { 
	BasicConfiguration.class, 
	SecurityConfiguration.class, 
	BusinessConfiguration.class
})
public class Application {
	
	/**
	 * Metodo principal
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
